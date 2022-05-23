select count(1) from (
    select count(name) from animal_ins ai
    where ai.name is not null
    group by name
) a