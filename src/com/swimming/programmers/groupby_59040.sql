select ANIMAL_TYPE, count(1) from animal_ins ai
group by ANIMAL_TYPE
order by ANIMAL_TYPE asc