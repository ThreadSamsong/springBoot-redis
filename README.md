## 介绍
springBoot2.X集成Redis集群限流，一致性Hash的实际使用。

## 分布式限流

限流就是限制系统的输入和输出流量已达到保护系统的目的。

一旦达到系统限制的阈值，就需要限制流量并采取一些措施以完成限制流量的目的。

比如：延迟处理，拒绝处理，或者部分拒绝处理等


## 一致性Hash算法的使用场景

   假设我们的将10台redis部署为我们的缓存系统，存储<k,v>数据，存储方式是：hash(k)%10，用来将数据分散到各个redis存储系统中。这样做，最大的问题就在于：如果此缓存系统扩展（比如：增加或减少redis服务器的数量），节点故障宕机等将会带来很高的代价。比如：我们业务量增大了，需要扩展我们的缓存系统，再增加一台redis作为缓存服务器，那么后来的数据<k,v>的散列方式变为了：hash(k)%11。我们可以看到，如果我们要查找扩展之前的数据，利用hash(k)%11，则会找不到对应的存储服务器。所以这个时候大量的数据失效了（访问不到了）。
    
   这时候，我们就要进行数据的重现散列，如果是将redis作为存储系统，则需要进行数据迁移，然后进行恢复，但是这个时候就意味着每次增减服务器的时候，集群就需要大量的通信，进行数据迁移，这个开销是非常大的。如果只是缓存，那么缓存就都失效了。这会形成缓存击穿，导致数据库压力巨大，可能会导致应用的崩溃。
  
## 一致性Hash算法的神秘面纱

  构造一个 0~2^32-1 大小的环。
  
  服务节点经过 hash 之后将自身存放到环中的下标中。
  
  客户端根据自身的某些数据 hash 之后也定位到这个环中。
  
  通过顺时针找到离他最近的一个节点，也就是这次路由的服务节点。
  
  考虑到服务节点的个数以及 hash 算法的问题导致环中的数据分布不均匀时引入了虚拟节点。

## TODO LIST
* [x] [Redis集群](#Redis)
* [x] [分布式限流](#Redis)
* [x] [一致性Hash算法](#Hash)

## 联系作者
- [906053856@qq.com]
