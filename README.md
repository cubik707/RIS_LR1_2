# Language Courses Management

Этот проект — веб-приложение для управления курсами, компаниями и расчетами стоимости.  
Работает на **Jakarta EE (TomEE)** и использует **MySQL** в качестве базы данных.

## 🚀 Технологии:
- **Jakarta EE (TomEE)**
- **MySQL**
- **JSP & Servlets**
- **JPA (Hibernate)**

---

## 📌 Настройка базы данных

Конфигурация базы данных происходит через **TomEE**, а не в `persistence.xml` напрямую.  

1. **Добавь MySQL-коннектор в TomEE**:  
   Скопируй JAR-файл `mysql-connector-java-<version>.jar` в папку:
2. **Настрой ресурс в `tomee.xml` (или `conf/server.xml`)**:  
`<Resource id="RIS_LR1_2" type="DataSource">
    JdbcDriver com.mysql.cj.jdbc.Driver
    JdbcUrl jdbc:mysql://localhost:3306/LanguageCourses?useSSL=false&serverTimezone=UTC
    factory org.apache.tomcat.jdbc.pool.DataSourceFactory
    UserName root
    Password your_password
</Resource>`
3. **Настрой `persistence.xml` для работы через JTA:**:
`<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             version="3.2">
    <persistence-unit name="default" transaction-type="JTA">
        <jta-data-source>RIS_LR1_2</jta-data-source>
        <properties>
            <property name="jakarta.persistence.provider" value="org.hibernate.jpa.HibernatePersistenceProvider"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.MySQLDialect"/>
            <property name="hibernate.hbm2ddl.auto" value="update"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
        </properties>
    </persistence-unit>
</persistence>`
