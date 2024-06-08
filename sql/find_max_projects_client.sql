SELECT c.name AS NAME, count(p.client_id) AS PROJECT_COUNT
FROM client c
JOIN project p ON c.id = p.client_id
GROUP BY p.client_id, c.name
HAVING count(p.client_id) = (SELECT MAX(project_count)
                             FROM (SELECT count(client_id) AS PROJECT_COUNT
                                   FROM project
                                   GROUP BY client_id) AS counts);