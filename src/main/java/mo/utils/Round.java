package mo.utils;

/**
 * @Author: gongzhanjing
 * @Date: 2018/11/6
 */
public class Round {
    public static void main(String[] args) {
        int rc = 7;
        int qc = 11;
        float ratio = Math.round(rc * 100F / qc) / 100F;
        System.out.println(ratio);
        String str = "sds";
        if (null != str && str.equals("sd")) {
            System.out.println("ds");
        }
        if (EventPlanningPlate.checkCode(1)) {
            System.out.println(EventPlanningPlate.values()[1]);
        }

    }

    enum EventPlanningPlate {
        Life_Application(0),       //生活应用
        Number_and_Operation(1),   //数与运算
        Graphic_Geometry(2),       //图形几何
        Logical_Reasoning(3),      //逻辑推理

        ;

        final int code;

        EventPlanningPlate(int code) {
            this.code = code;
        }

        public static boolean checkCode(int code) {
            for (EventPlanningPlate type : EventPlanningPlate.values()) {
                if (type.getCode() == code) {
                    return true;
                }
            }
            return false;
        }

        public int getCode() {
            return code;
        }
    }
}