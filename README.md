# seata-auto-config
## 问题描述：用于复现升级seata1.4.2后hakari数据源自动代理失败问题
## 环境：seata1.4.2+springboot2.0.6.RELEASE+springcloudFinchley.SR2+mysql5.7+nacos1.4.0+jdk8
### 问题根源：在自动代理配置类加载的时候未能完成hakari数据源对象的实例化

#### 目前解决方式
#### 验证发现使用Druid数据源1.1.10可以正常代理，目前我们这边的解决办法也就是暂时切换为Druid的数据源。
#### 通过debug发现覆盖io.seata.spring.boot.autoconfigure.SeataDataSourceAutoConfiguration类，将@ConditionalOnBean(DataSource.class)注释掉，使用early暴露出来的对象也能在hakari数据源下代理成功。
#### 升级springboot的版本也能解决hakari下代理失败的问题

具体优雅的实现方式就需要各位大佬来看看了

