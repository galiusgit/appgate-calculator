select * from operation where calc_session_id = '';

select * from operation where calc_session_id = '' and type = 'RESULT'
order by creation_date desc limit 1;