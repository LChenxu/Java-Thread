package callback;

/**
 * @author lichenxu
 * @version V1.0
 * @Package callback
 * @date 2020/12/7 22:59
 * @example:
 * @Description:
 */
public class AnotherFunction {
    CallBack callBack;

    public String doCallBack(){
        return callBack.findCallBack();
    }

    public void setCallBack(CallBack callBack){
        this.callBack =callBack;
    }

    public static void main(String[] args) {
        AnotherFunction a = new AnotherFunction();
        a.setCallBack(new CallBack() {
            @Override
            public String findCallBack() {
                return "adasfafsafsa";
            }
        });

        String  info = a.doCallBack();
        System.out.println(info);
    }
}
