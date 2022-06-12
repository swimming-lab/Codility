select name, count(name) from animal_ins ai
where name is not null
group by NAME
having count(name) > 1
order by name asc