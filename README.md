# mobile-api

# generate executable jar
gradle build

# upload to local maven repository
gradle install

# run in dev/test environment
gradle bootRun

# upload to nexus (proxy for remote maven repository)
gradle upload

# run in production (replace version number when needed)
java -jar build/libs/mobile-api-1.0-SNAPSHOT.jar

# data source configuration
src/main/resources/ds_attribute.properties
src/main/resources/ds_marketing.properties
src/main/resources/ds_order.properties
src/main/resources/ds_page.properties
src/main/resources/ds_price.properties
src/main/resources/ds_product.properties
src/main/resources/ds_stock.properties
src/main/resources/ds_user.properties

# logging setting
src/main/resources/logback.properties

# mybatis generator
# 进入各个service之后执行gradle dbgen, 注意不能覆盖自己写的mapper方法