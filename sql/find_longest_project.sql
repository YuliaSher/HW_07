SELECT
    p.name AS NAME,
    EXTRACT(YEAR FROM AGE(p.finish_date, p.start_date)) * 12 + EXTRACT(MONTH FROM AGE(p.finish_date, p.start_date)) AS MONTH_COUNT
FROM
    project p
WHERE
    EXTRACT(YEAR FROM AGE(p.finish_date, p.start_date)) * 12 + EXTRACT(MONTH FROM AGE(p.finish_date, p.start_date)) = (
        SELECT MAX(EXTRACT(YEAR FROM AGE(finish_date, start_date)) * 12 + EXTRACT(MONTH FROM AGE(finish_date, start_date)))
        FROM project
    );