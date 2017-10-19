package cn.gyyx.frame.mybatis.enums;

public enum Optimize {
    /**
     * 默认支持方式
     */
    DEFAULT("default", "默认方式"),
    /**
     * aliDruid,需添加相关依赖jar包
     */
    ALI_DRUID("aliDruid", "依赖aliDruid模式"),
    /**
     * jsqlparser方式,需添加相关依赖jar包
     */
    JSQLPARSER("jsqlparser", "jsqlparser方式");

    private final String optimize;

    private final String desc;

    Optimize(final String optimize, final String desc) {
        this.optimize = optimize;
        this.desc = desc;
    }

    /**
     * <p>
     * 获取优化类型.如果没有找到默认DEFAULT
     * </p>
     *
     * @param optimizeType
     *            优化方式
     * @return
     */
    public static Optimize getOptimizeType(String optimizeType) {
        for (Optimize optimize : Optimize.values()) {
            if (optimize.getOptimize().equalsIgnoreCase(optimizeType)) {
                return optimize;
            }
        }
        return DEFAULT;
    }

    public String getOptimize() {
        return this.optimize;
    }

    public String getDesc() {
        return this.desc;
    }

}
