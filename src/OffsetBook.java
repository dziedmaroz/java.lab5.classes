
 

 

/**
 *
 * @author lucian
 */

import java.util.List;
 
public class OffsetBook
{
    public class Test
    {
        private String _subjName;
        private String _date;
        private boolean _isPassed;
        private String _result;
        
        public Test(String _subjName, String _date, boolean _isPassed, String _result) {
            this._subjName = _subjName;
            this._date = _date;
            this._isPassed = _isPassed;
            this._result = _result;
        }

        public String getDate() {
            return _date;
        }

        public boolean isIsPassed() {
            return _isPassed;
        }

        public String getResult() {
            return _result;
        }

        public String getSubjName() {
            return _subjName;
        }

        public void setDate(String _date) {
            this._date = _date;
        }

        public void setIsPassed(boolean _isPassed) {
            this._isPassed = _isPassed;
        }

        public void setResult(String _result) {
            this._result = _result;
        }

        public void setSubjName(String _subjName) {
            this._subjName = _subjName;
        }

        @Override
        public String toString() {
            return "Test{" + "_subjName=" + _subjName + "_date=" + _date + "_isPassed=" + _isPassed + "_result=" + _result + '}';
        }

        private List<Test> _exams;
        private List<Test> _offsets;

        public boolean  addExam (Test exam)
        {
           return _exams.add(exam);
        }

        public boolean addOffset (Test offTest)
        {
            return _offsets.add(this);            
        }





        
    }

    
}
