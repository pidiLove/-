//package com.pa.park.core.util;
///** 
// * @author wangpei 
// * @version 创建时间：2017年5月13日 上午12:13:28 
// * memcached缓存工具类
// */
//public class MemcachedUtil {
//	/** 
//     * memcached客户端单例，唯一实例 
//     */  
//    private static MemCachedClient cachedClient = new MemCachedClient();  
//  
//    /** 
//     * 初始化连接池 
//     */  
//    static {  
//        // 获取连接池的实例  
//        SockIOPool pool = SockIOPool.getInstance();  
//  
//        // 服务器列表及其权重  
//        String[] servers = { "127.0.0.1:11211" };  
//        Integer[] weights = { 3 };  
//  
//        // 设置服务器信息  
//        pool.setServers(servers);  
//        pool.setWeights(weights);  
//  
//        // 设置初始连接数、最小连接数、最大连接数、最大处理时间  
//        pool.setInitConn(10);  
//        pool.setMinConn(10);  
//        pool.setMaxConn(1000);  
//        pool.setMaxIdle(1000 * 60 * 60);  
//  
//        // 设置连接池守护线程的睡眠时间  
//        pool.setMaintSleep(60);  
//  
//        // 设置TCP参数，连接超时  
//        pool.setNagle(false);  
//        pool.setSocketTO(60);  
//        pool.setSocketConnectTO(0);  
//  
//        // 初始化并启动连接池  
//        pool.initialize();  
//  
//        // 压缩设置，超过指定大小的都压缩  
//        // cachedClient.setCompressEnable(true);  
//        // cachedClient.setCompressThreshold(1024*1024);  
//  
//        cachedClient.setPrimitiveAsString(true);// 设置序列化  
//  
//    }  
//  
//    /** 
//     * 构造函数:工具类，禁止实例化 
//     */  
//    private MemcachedUtil() {  
//    }  
//  
//    /*** 
//     * 功能描述:新增一个缓存数据，如果key存在不会新增 
//     *  
//     * @param 缓存的key 
//     * @param 缓存的值 
//     * @return 操作结果 
//     */  
//    public static boolean add(String key, Object value) {  
//        return cachedClient.add(key, value);  
//    }  
//  
//    /** 
//     * 功能描述:新增一个缓存数据，设置过期时间参数为秒 
//     * @param 缓存的key 
//     * @param 缓存的值 
//     * @param 缓存时间 
//     * @return 操作结果 
//     */  
//    public static boolean add(String key, Object value, Integer expire) {  
//        return cachedClient.add(key, value, expire);  
//    }  
//  
//    /** 
//     * 功能描述:新增一个缓存数据，如果存在key，则更新该key的值 
//     * @param 缓存的key 
//     * @param 缓存的值 
//     * @return 操作结果 
//     */  
//    public static boolean put(String key, Object value) {  
//        return cachedClient.set(key, value);  
//    }  
//  
//    /** 
//     * 功能描述:新增一个缓存数据，如果存在key，则更新该key的值 
//     * @param 缓存的key 
//     * @param 缓存的值 
//     * @param 缓存时间 
//     * @return 操作结果 
//     */  
//    public static boolean put(String key, Object value, Integer expire) {  
//        return cachedClient.set(key, value, expire);  
//    }  
//  
//    /** 
//     * 功能描述:替换一个缓存数据，如果存在key则替换，否则返回false 
//     * @param key 
//     * @param value 
//     * @return 操作结果 
//     */  
//    public static boolean replace(String key, Object value) {  
//        return cachedClient.replace(key, value);  
//    }  
//  
//    /** 
//     * 功能描述:替换一个缓存数据，如果存在key则替换，否则返回false 
//     * @param key 
//     * @param value 
//     * @param 缓存时间 
//     * @return 操作结果 
//     */  
//    public static boolean replace(String key, Object value, Integer expire) {  
//        return cachedClient.replace(key, value, expire);  
//    }  
//  
//    /** 
//     * 功能描述:根据key得到一个缓存数据 
//     * @param key 
//     * @return 操作结果 
//     */  
//    public static Object get(String key) {  
//        return cachedClient.get(key);  
//    }  
//  
//    /** 
//     * 功能描述:刷新全部缓存(就是将所有缓存设置为过期，以后放入的会覆盖掉这些过期的缓存数据) 
//     *  
//     * @return 操作结果 
//     */  
//    public static boolean flushAll() {  
//        return cachedClient.flushAll();  
//    }  
//      
//    /*** 
//     * 功能描述:根据key删除一个缓存数据 
//     * @return 操作结果 
//     */  
//    public static boolean delete(String key){  
//        return cachedClient.delete(key);  
//    }  
//}
