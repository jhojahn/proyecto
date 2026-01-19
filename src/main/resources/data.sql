-- INFO -> tabla: infos (NO existe image_url, existe foto_url)
INSERT INTO infos (nombre, descripcion, foto_url, email, linkedin, github)
VALUES (
  'Jhojahn Sebastian Ramirez',
  'Desarrollador Full Stack especializado en Spring Boot',
  'https://www.mancity.com/meta/media/i2gekadz/pep-guardiola-1.png',
  'jhojahn@gmail.com',
  'https://linkedin.com/in/jhojahn',
  'https://github.com/jhojahn'
);

-- ESTUDIOS -> tabla: estudios (no image_url)
INSERT INTO estudios (titulo, descripcion, institucion, fecha_inicio, fecha_fin)
VALUES (
  'Grado Superior DAM',
  'Formación en desarrollo de aplicaciones multiplataforma',
  'IES Luis Vives',
  '2023-09-01',
  '2026-06-20'
);

-- EXPERIENCIAS -> tabla: experiencias (no image_url)
INSERT INTO experiencias (puesto, empresa, descripcion, fecha_inicio, fecha_fin)
VALUES (
  'Programador Juniord',
  'Tech Solutions SL',
  'Desarrollo backend con Spring Boot y APIs REST',
  '2024-03-01',
  '2025-01-31'
);

-- LENGUAJES -> tabla: lenguajes (NO nivel, NO image_url, existe icono_url)
INSERT INTO lenguajes (nombre, icono_url)
VALUES (
  'Java',
  'https://okhosting.com/wp-content/uploads/2019/01/java.jpg'
);

-- PROYECTOS -> tabla: proyectos (NO url, existe github_url, image_url y fecha)
INSERT INTO proyectos (nombre, descripcion, github_url, image_url, fecha)
VALUES (
  'Portfolio Web',
  'Web personal desarrollada con Spring Boot y Thymeleaf',
  'https://github.com/jhojahn/portfolio',
  'https://www.mancity.com/meta/media/i2gekadz/pep-guardiola-1.png',
  '2025-01-10'
);
