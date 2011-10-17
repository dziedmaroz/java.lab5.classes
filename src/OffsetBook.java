
 

 

/**
 *
 * @author lucian
 */

import java.util.List;
 
public class OffsetBook
{
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

     public class Exam extends Test
     {
         private int _result;

        public Exam(String _subject, boolean _isPassed, String _date, int _result)
        {
            this._result = _result;
        }

        public int getResult() {
            return _result;
        }

        public void setResult(int _result) {
            this._result = _result;
        }
     }

     private List<Exam> _exams;
     private List<Offset> _offsets;
     
}
