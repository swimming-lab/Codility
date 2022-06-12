-- Neutered Male 중성화 51
-- Spayed Female 중성화 45
-- Intact Female 온전한 2
-- Intact Male 온전한 2
select ai.animal_id, ai.animal_type, ai.name from animal_ins ai
left join animal_outs ao on ai.animal_id = ao.animal_id
where (ai.SEX_UPON_INTAKE = 'Intact Female'
    or ai.SEX_UPON_INTAKE = 'Intact Male')
  and (ao.SEX_UPON_OUTCOME = 'Neutered Male'
    or ao.SEX_UPON_OUTCOME = 'Spayed Female')