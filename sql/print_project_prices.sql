SELECT p.name,
       (EXTRACT(YEAR FROM AGE(p.finish_date, p.start_date)) * 12 +
        EXTRACT(MONTH FROM AGE(p.finish_date, p.start_date))) * sum(salary) as PRICE
FROM project p
         JOIN public.project_worker pw on p.id = pw.project_id
         JOIN public.worker w on w.id = pw.worker_id
GROUP BY p.name, p.finish_date, p.start_date
ORDER BY PRICE DESC;