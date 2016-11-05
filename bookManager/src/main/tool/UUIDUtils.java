package main.tool;

import java.util.UUID;

/**
* UUID工具类
* @author zhangcd
*
*/
public final class UUIDUtils {

        /**
         * 获取一个新的UUID
         * @return
         */
        static String createUUID() {
                return str(UUID.randomUUID());
        }

        private static String str(UUID uuid) {
                long mostSigBits = uuid.getMostSignificantBits();
                long leastSigBits = uuid.getLeastSignificantBits();
                return (digits(mostSigBits >> 32, 8)
                                + digits(mostSigBits >> 16, 4)
                                + digits(mostSigBits, 4)
                                + digits(leastSigBits >> 48, 4)
                                + digits(leastSigBits, 12));
        }

        private static String digits(long val, int digits) {
                long hi = 1L << (digits * 4);
                return Long.toHexString(hi | (val & (hi - 1))).substring(1);
        }

} 