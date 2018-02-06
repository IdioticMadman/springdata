# Spring Data学习

### 传统jdbc模式(JDBCUtil)
1. 获取connection
2. 获取statement
3. 从resultSet里面获取结果

重复工作很多，需要频繁的自己去操作以上三个对象

### JDBCTemplate (beans.xml)
使用spring进行管理创建dataSource以及JdbcTemplate，我们通过Spring容器中的JdbcTemplate来操作数据库

---
以上两种模式，都是先创建表然后创建对应的类。然后对数据库进行增删改的操作

### Spring Jpa框架

1. 导入包
    ```
    <!--spring data jpa-->
    <dependency>
        <groupId>org.springframework.data</groupId>
        <artifactId>spring-data-jpa</artifactId>
        <version>1.8.0.RELEASE</version>
    </dependency>
    
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-entitymanager</artifactId>
        <version>4.3.6.Final</version>
    </dependency>
    ```
2. 配置spring容器中
    ```
    <bean id="entityManagerFactory" class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="jpaVendorAdapter">
            <bean class="org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter"/>
        </property>
        <property name="packagesToScan" value="com.robert"/>
        <property name="jpaProperties">
            <props>
                <prop key="hibernate.ejb.naming_strategy">org.hibernate.cfg.ImprovedNamingStrategy</prop>
                <prop key="hibernate.dialect">org.hibernate.dialect.MySQL5InnoDBDialect</prop>
                <prop key="hibernate.show_sql">true</prop>
                <prop key="hibernate.format_sql">true</prop>
                <prop key="hibernate.hbm2ddl.auto">update</prop>
            </props>
        </property>
    </bean>
    <bean id="transactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
        <property name="entityManagerFactory" ref="entityManagerFactory"/>
    </bean>
    <tx:annotation-driven transaction-manager="transactionManager"/>
    <jpa:repositories base-package="com.robert.data" entity-manager-factory-ref="entityManagerFactory"/>
    ```
3. 通过编写实体类设置对应的注解可以生成对应的实体表
    具体的需要去学习hibernate框架
4. 编写Repository接口
       
    * 通过约定的方法名去查询数据
    * 通过@Query注解去查询数据
        如果需要更新数据的话
            1. 需要添加@modify
            2. 注意事务的管理
            
    接口可以用`@RepositoryDefinition`标注或者直接继承`org.springframework.data.repository.Repository`来实现
    通过`org.springframework.data.repository.Repository`衍生出下面三种接口
    1. `org.springframework.data.repository.CrudRepository` 添加CRUD的操作
    2. `org.springframework.data.repository.PagingAndSortingRepository` 添加排序以及分页的操作
    3. `org.springframework.data.jpa.repository.JpaRepository` 
    如果需要添加筛选条件的支持的话，同时实现`org.springframework.data.jpa.repository.JpaSpecificationExecutor`接口便可




