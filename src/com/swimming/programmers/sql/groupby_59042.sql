-- 2013-12-22 11:30:00
select hour, count(hour) from (
    select substring(datetime, 12, 2) hour from animal_outs
) a
group by hour
having '08' < hour and hour < '20'
order by hour asc
