package Helper;

public class Datas {
    public enum MobileNumber {
        valid_num1(7897897897L),
        invalid_num1(5879879879L),
        valid_num2(7777777777L),
        prod_num1(9874566547L);

        private final long number;

        MobileNumber(long number) {
            this.number = number;
        }

        public long getNumber() {
            return number;
        }
    }

    public enum MobileNumbervalidationErrorMsg {
        msg1("Please enter a valid phone number"),
        msg2("Please enter your phone number");
        private final String message;

        MobileNumbervalidationErrorMsg(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public enum otpValidationErrorMsg {
        msg1("The OTP you have entered is incorrect. Please try again.");
        private final String errorMsg;

        otpValidationErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        public String getErrorMsg() {
            return errorMsg;
        }
    }

    public enum signUpScreenValidationErrorMsg
    {
        userName1("Enter your Name"),
        UserName2("Name must be between 3 and 30 characters"),
        email("Invalid email"),
        password("Password must be at least 8 characters long");
        private final  String errorMsg;
        signUpScreenValidationErrorMsg(String errorMsg)
        {
            this.errorMsg=errorMsg;
        }
        public String getErrorMsg() {
            return errorMsg;
        }
    }
    public enum addBusinessTextBoxErrorMsg
    {
        error_msg1("Please enter your business name."),
        error_msg2("Business name should be between 2 and 30 characters.");
        private  final String errorMsg;
        addBusinessTextBoxErrorMsg(String errorMsg)
        {
            this.errorMsg=errorMsg;
        }
        public String getErrorMsg()
        {
            return this.errorMsg;
        }
    }
    public  enum  remarks
    {
        cashRemark("boys"),
        cashRemark1("jack");
        private final String remark;
        remarks(String remark)
        {
            this.remark=remark;
        }
        public String getRemark()
        {
            return  this.remark;
        }
    }
    public enum category
    {
        category1("abc");
        private final String c;
        category(String c)
        {
            this.c=c;
        }
        public String getCategory()
        {
            return this.c;
        }
    }
}
