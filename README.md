# about-me-admin
个人网页的后台
始创于：2019‎年‎6‎月‎24‎日，‏‎16:41:55

##遇到的问题和反思：

1、2019-07-06 09:29:15
在整合quartz时，一致启动报错，从网上的帖子中找了很多解决措施仍然无法解决
于是，溯本求源，去看官方的文档，找到了配置文件的问题，改正后，顺利启动。
启示：网上的帖子很多，针对的问题很可能不是自己真正遇到的，如果难以解决，
就回归本初，研究官方文档，




分日查询访问量
select DATE_FORMAT(visit_time,'%Y-%m-%d'),COUNT(*) FROM visit GROUP BY DAY(visit_time); 


用到的技术

jpa
spring security
spring boot
maven
lombok
httpclient
quartz