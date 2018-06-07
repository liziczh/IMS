-- 查询product
select *
from "product" 
where "proName" like '%' || '' || '%' 
and "count" between 0 and 100
and "dirName" = '电脑/办公'
order by "proId"

-- 查询record
select * 
from "record" 
where ("date" between ? and ?) 
and "recordType" = ? 
and "proName" in (select "proName" from "product" where "proName" = ?)

-- 更新product
update "product" 
set "proName" = ?, "dirName" = ?, "supplier" = ?, "brand" = ? 
where "proId" = ?
-- 更新record
update "record" 
set "proName" = '罗技G102'
where "proId" = 1

-- 分页
select * 
from ( 
  select "temp".*, ROWNUM "rn" 
  from  "product" "temp" 
  where ROWNUM <= currengPage * pageSize ) 
where "rn" > (currentPage-1) * pageSize

-- 序列：proId自增
create sequence proId_seq
increment by 1
START WITH 000001
maxvalue 999999
nominvalue
nocycle
nocache
-- 统计图
select sum("record"."count"),"product"."dirName"
from "record","product" 
WHERE "record"."proId" = "product"."proId"
AND "recordType" = 'in' 
AND "record"."date" BETWEEN '2018-01-01' AND '2018-06-01' 
GROUP BY "product"."dirName"

