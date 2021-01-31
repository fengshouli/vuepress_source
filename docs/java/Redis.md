# Redis

## 1.什么是Redis?

[redis中文官网](http://redis.cn/)  
[redis英文官网](https://redis.io/)

Redis 是一个开源（BSD许可）的，内存中的数据结构存储系统，它可以用作数据库、缓存和消息中间件。  

它支持多种类型的数据结构，如    	    [字符串（strings）](http://redis.cn/topics/data-types-intro.html#strings)，    [散列（hashes）](http://redis.cn/topics/data-types-intro.html#hashes)，    [列表（lists）](http://redis.cn/topics/data-types-intro.html#lists)，    [集合（sets）](http://redis.cn/topics/data-types-intro.html#sets)，    [有序集合（sorted sets）](http://redis.cn/topics/data-types-intro.html#sorted-sets) 与范围查询，    [bitmaps](http://redis.cn/topics/data-types-intro.html#bitmaps)，    [hyperloglogs](http://redis.cn/topics/data-types-intro.html#hyperloglogs) 和     [地理空间（geospatial）](http://redis.cn/commands/geoadd.html) 索引半径查询。     Redis 内置了    [复制（replication）](http://redis.cn/topics/replication.html)，[LUA脚本（Lua scripting）](http://redis.cn/commands/eval.html)，    [LRU驱动事件（LRU eviction）](http://redis.cn/topics/lru-cache.html)，[事务（transactions）](http://redis.cn/topics/transactions.html)    和不同级别的    [磁盘持久化（persistence）](http://redis.cn/topics/persistence.html)，    并通过    [Redis哨兵（Sentinel）](http://redis.cn/topics/sentinel.html)和自动    [分区（Cluster）](http://redis.cn/topics/cluster-tutorial.html)提供高可用性（high availability）。