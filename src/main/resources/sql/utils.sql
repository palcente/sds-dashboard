update batch_step_execution set 
start_time = timestampadd('DAY',(select timestampdiff('DAY',max(start_time),current_timestamp()) from batch_step_execution),start_time),
end_time = timestampadd('DAY',(select timestampdiff('DAY',max(start_time),current_timestamp()) from batch_step_execution),last_updated),
last_updated= timestampadd('DAY',(select timestampdiff('DAY',max(start_time),current_timestamp()) from batch_step_execution),last_updated);

update batch_job_execution set
start_time = timestampadd('DAY',(select timestampdiff('DAY',max(start_time),current_timestamp()) from batch_step_execution),start_time);