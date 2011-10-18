package lab5classes;

/**
 *
 * @author lucian
 */

import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class  Group
{
    public class OffsetBook
    {
        /**This class describes term session*/
        public class Session
        {
            private  String _sem;

            public Session(String _sem)
            {
                this._sem = _sem;
            }

            public String getSem()
            {
                return _sem;
            }

            public void setSem(String _sem)
            {
                this._sem = _sem;
            }
            
            /**Parent class for Exam and Offset classes*/
            public class Test
            {
                private String _subject;
                private boolean _isPassed;
                private String _date;

                public   Test () {};
                public Test(String _subject, boolean _isPassed, String _date)
                {
                this._subject = _subject;
                this._isPassed = _isPassed;
                this._date = _date;
                }

                public String getDate()
                {
                return _date;
                }

                public boolean isPassed()
                {
                return _isPassed;
                }


                public String getSubject()
                {
                return _subject;
                }

                public void setDate(String _date)
                {
                this._date = _date;
                }

                public void setIsPassed(boolean _isPassed)
                {
                this._isPassed = _isPassed;
                }

                public void setSubject(String _subject)
                {
                this._subject = _subject;
                }
            }

            /**Class wich describes offset state*/
            public class Offset extends Test
            {
                private boolean _result;

                public Offset(String _subject, boolean _isPassed, String _date, boolean _result)
                {
                this._result = _result;
                }



                public boolean getResult()
                {
                return _result;
                }

                public void setResult(boolean _result)
                {
                this._result = _result;
                }
            }

            /**Class wich describes Exam state*/
            public class Exam extends Test
            {
                private int _result;

                public Exam(String _subject, boolean _isPassed, String _date, int _result)
                {
                   this._result = _result;
                }

                public int getResult()
                {
                  return _result;
                }

                public void setResult(int _result)
                {
                   this._result = _result;
                }
            }

            private List<Exam> _exams;
            private List<Offset> _offsets;


            public boolean addExam (Exam exam)
            {
              return _exams.add(exam);
            }

            public boolean rmExam (Exam exam)
            {
                return _exams.remove(exam);
            }

            public boolean addOffset (Offset offset)
            {
               return _offsets.add(offset);
            }

            public boolean rmOffset (Offset offset)
            {
              return _offsets.remove(offset);
            }
        }

        private String _bookNum;
        private String _name;
        private List<Session> _sessions;

        public OffsetBook(String _bookNum, String _name)
        {
            this._bookNum = _bookNum;
            this._name = _name;
        }

        public String getBookNum()
        {
            return _bookNum;
        }

        public String getName()
        {
            return _name;
        }

        public void setBookNum(String _bookNum)
        {
            this._bookNum = _bookNum;
        }

        public void setName(String _name)
        {
            this._name = _name;
        }
    }

    List<OffsetBook> _students;

    public Group(String xmlFile)
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document dom = null;
        try
        {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse(xmlFile);
        }
        catch(ParserConfigurationException pce)
        {
            System.out.println(pce.toString());
	}
        catch(SAXException se)
        {
            System.out.println(se.toString());
        }
        catch(IOException ioe)
        {
            System.out.println(ioe.toString());
	}

        Element docEle = dom.getDocumentElement();
        NodeList nl=docEle.getElementsByTagName("book");
        if (nl!=null && nl.getLength()>0)
        {
            for (int i=0;i<nl.getLength();i++)
            {
                Element curBook =(Element) nl.item(i);
                OffsetBook tmpBook = new OffsetBook(curBook.getAttribute("num"),curBook.getAttribute("owner"));
                NodeList nlSessions = curBook.getElementsByTagName("session")    ;
                if (nlSessions!=null && nl.getLength()>0)
                {
                    for (int j=0;j<nl.getLength();j++)
                    {
                        Element curSession = (Element) nlSessions.item(j);
                        OffsetBook.Session tmpSession = new OffsetBook.Session (curSession.getAttribute("sem"));

                    }
                }
            }
        }

    }

}
