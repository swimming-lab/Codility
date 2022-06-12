
select ai.animal_id, ai.name,
case
   when (SEX_UPON_INTAKE like 'Neutered%') then 'O'
   when (SEX_UPON_INTAKE like 'Spayed%') then 'O'
   else 'X'
end as '중성화' from animal_ins ai
order by animal_id