package mo.dao.model;

/**
 * @Author: gongzhanjing
 * @Date: 2018/10/25
 */
public class em {
    public static enum PublishState {
        ONLINE(1),
        PRE_RELEASE(2),

        ;
        public final int code;

        PublishState(int code) {
            this.code = code;
        }
    }
}
