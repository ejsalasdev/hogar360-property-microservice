-- Insertar los 32 departamentos de Colombia
INSERT IGNORE INTO departments (id, name, description) VALUES 
(1, 'Antioquia', 'Departamento ubicado en la región noroeste de Colombia, conocido por su desarrollo industrial y cultural'),
(2, 'Atlántico', 'Departamento de la región Caribe, importante centro económico y turístico del norte del país'),
(3, 'Bolívar', 'Departamento caribeño famoso por su patrimonio histórico y turismo cultural'),
(4, 'Boyacá', 'Departamento andino con rica historia independentista y tradición agrícola'),
(5, 'Caldas', 'Departamento del eje cafetero, reconocido por la producción de café de alta calidad'),
(6, 'Caquetá', 'Departamento amazónico con gran biodiversidad y recursos naturales'),
(7, 'Casanare', 'Departamento de los Llanos Orientales con importante actividad petrolera y ganadera'),
(8, 'Cauca', 'Departamento del suroccidente con diversidad étnica y cultural destacada'),
(9, 'Cesar', 'Departamento caribeño conocido por la música vallenata y la minería'),
(10, 'Córdoba', 'Departamento caribeño con tradición ganadera y agrícola'),
(11, 'Cundinamarca', 'Departamento central que rodea la capital, importante centro económico y político'),
(12, 'Chocó', 'Departamento del Pacífico con la mayor biodiversidad del país y riqueza cultural afrocolombiana'),
(13, 'Huila', 'Departamento andino famoso por su café especial y patrimonio arqueológico'),
(14, 'La Guajira', 'Departamento caribeño con cultura wayúu y importantes yacimientos de carbón'),
(15, 'Magdalena', 'Departamento caribeño con atractivos turísticos y patrimonio histórico'),
(16, 'Meta', 'Departamento llanero con desarrollo agroindustrial y petrolero'),
(17, 'Nariño', 'Departamento fronterizo del sur con diversidad geográfica y cultural'),
(18, 'Norte de Santander', 'Departamento fronterizo con Venezuela, importante corredor comercial'),
(19, 'Putumayo', 'Departamento amazónico fronterizo con Ecuador, rico en recursos naturales'),
(20, 'Quindío', 'Departamento del eje cafetero, corazón de la zona cafetera colombiana'),
(21, 'Risaralda', 'Departamento cafetero con importante desarrollo tecnológico e industrial'),
(22, 'San Andrés y Providencia', 'Archipiélago caribeño con cultura raizal y turismo de playa'),
(23, 'Santander', 'Departamento andino con tradición comercial y turismo de aventura'),
(24, 'Sucre', 'Departamento caribeño con tradición ganadera y agrícola'),
(25, 'Tolima', 'Departamento andino con agricultura diversificada y folclor musical'),
(26, 'Valle del Cauca', 'Departamento del suroccidente, importante centro industrial y económico'),
(27, 'Arauca', 'Departamento llanero fronterizo con Venezuela, con actividad petrolera'),
(28, 'Amazonas', 'Departamento selvático con la mayor diversidad biológica del país'),
(29, 'Guainía', 'Departamento amazónico con comunidades indígenas y selva tropical'),
(30, 'Guaviare', 'Departamento de transición entre los Andes y la Amazonía'),
(31, 'Vaupés', 'Departamento amazónico con gran diversidad étnica y cultural'),
(32, 'Vichada', 'Departamento llanero con extensas sabanas y recursos naturales'),
(33, 'Bogotá D.C.', 'Distrito Capital, centro político, económico y cultural del país');

-- Insertar ciudades principales por departamento
INSERT IGNORE INTO cities (id, name, description, department_id) VALUES 
-- Antioquia
(1, 'Medellín', 'Capital de Antioquia, ciudad de la eterna primavera e innovación', 1),
(2, 'Bello', 'Ciudad metropolitana conocida por su industria y cercanía a Medellín', 1),
(3, 'Itagüí', 'Municipio industrial del área metropolitana de Medellín', 1),
(4, 'Envigado', 'Ciudad próspera del sur del valle de Aburrá', 1),
(5, 'Rionegro', 'Ciudad del oriente antioqueño, importante centro logístico', 1),
(6, 'Sabaneta', 'Municipio del área metropolitana con alta calidad de vida', 1),
(7, 'Apartadó', 'Centro agroindustrial del Urabá antioqueño', 1),
(8, 'Turbo', 'Puerto principal del Golfo de Urabá', 1),
(9, 'Caucasia', 'Ciudad del bajo Cauca con actividad minera', 1),
(10, 'Copacabana', 'Municipio del norte del área metropolitana de Medellín', 1),

-- Atlántico
(11, 'Barranquilla', 'Capital del Atlántico, puerta de oro de Colombia', 2),
(12, 'Soledad', 'Municipio metropolitano con importante desarrollo industrial', 2),
(13, 'Malambo', 'Ciudad industrial del área metropolitana de Barranquilla', 2),
(14, 'Sabanalarga', 'Municipio del centro del Atlántico con tradición ganadera', 2),
(15, 'Galapa', 'Municipio metropolitano de Barranquilla en crecimiento', 2),
(16, 'Puerto Colombia', 'Municipio costero con historia portuaria y turística', 2),

-- Bolívar
(17, 'Cartagena', 'Ciudad heroica, patrimonio histórico de la humanidad', 3),
(18, 'Magangué', 'Puerto fluvial sobre el río Magdalena', 3),
(19, 'Turbaco', 'Municipio metropolitano de Cartagena en expansión', 3),
(20, 'El Carmen de Bolívar', 'Municipio de los Montes de María', 3),
(21, 'Arjona', 'Municipio del Canal del Dique con tradición agrícola', 3),

-- Boyacá
(22, 'Tunja', 'Capital de Boyacá, ciudad universitaria y colonial', 4),
(23, 'Duitama', 'Ciudad industrial del corredor férreo boyacense', 4),
(24, 'Sogamoso', 'Ciudad del acero y centro siderúrgico nacional', 4),
(25, 'Chiquinquirá', 'Ciudad religiosa, capital mariana de Colombia', 4),
(26, 'Villa de Leyva', 'Municipio colonial, patrimonio histórico y turístico', 4),

-- Caldas
(27, 'Manizales', 'Capital de Caldas, ciudad universitaria del eje cafetero', 5),
(28, 'La Dorada', 'Puerto multimodal sobre el río Magdalena', 5),
(29, 'Chinchiná', 'Municipio cafetero con tradición industrial', 5),
(30, 'Riosucio', 'Municipio minero y cultural de Caldas', 5),

-- Caquetá
(31, 'Florencia', 'Capital del Caquetá, puerta de entrada a la Amazonía', 6),
(32, 'San Vicente del Caguán', 'Municipio ganadero del sur del Caquetá', 6),

-- Casanare
(33, 'Yopal', 'Capital de Casanare, centro petrolero de los llanos', 7),
(34, 'Aguazul', 'Municipio petrolero y ganadero de Casanare', 7),
(35, 'Villanueva', 'Municipio llanero con tradición agropecuaria', 7),

-- Cauca
(36, 'Popayán', 'Ciudad blanca, capital del Cauca con patrimonio colonial', 8),
(37, 'Santander de Quilichao', 'Municipio industrial del norte del Cauca', 8),
(38, 'Puerto Tejada', 'Municipio del norte del Cauca con tradición azucarera', 8),

-- Cesar
(39, 'Valledupar', 'Capital del Cesar, cuna del vallenato', 9),
(40, 'Aguachica', 'Municipio del sur del Cesar con actividad agrícola', 9),
(41, 'Bosconia', 'Municipio del centro del Cesar', 9),

-- Córdoba
(42, 'Montería', 'Capital de Córdoba, centro ganadero y agrícola', 10),
(43, 'Cereté', 'Municipio del alto Sinú con tradición ganadera', 10),
(44, 'Sahagún', 'Municipio del centro de Córdoba', 10),
(45, 'Lorica', 'Puerto fluvial del bajo Sinú', 10),

-- Cundinamarca
(46, 'Soacha', 'Municipio metropolitano al sur de Bogotá', 11),
(47, 'Girardot', 'Ciudad turística y puerto sobre el río Magdalena', 11),
(48, 'Zipaquirá', 'Ciudad de la sal y patrimonio turístico', 11),
(49, 'Facatativá', 'Municipio occidental de la sabana de Bogotá', 11),
(50, 'Chía', 'Municipio de alta calidad de vida en la sabana norte', 11),
(51, 'Mosquera', 'Municipio occidental metropolitano de Bogotá', 11),
(52, 'Madrid', 'Municipio de la sabana de Bogotá con desarrollo logístico', 11),
(53, 'Funza', 'Municipio industrial de la sabana occidental', 11),
(54, 'Cajicá', 'Municipio de la sabana norte con desarrollo residencial', 11),
(55, 'Fusagasugá', 'Capital del Sumapaz, ciudad universitaria', 11),

-- Chocó
(56, 'Quibdó', 'Capital del Chocó, centro de la cultura afrocolombiana', 12),
(57, 'Istmina', 'Municipio minero del centro del Chocó', 12),

-- Huila
(58, 'Neiva', 'Capital del Huila, centro comercial del alto Magdalena', 13),
(59, 'Pitalito', 'Municipio cafetero del sur del Huila', 13),
(60, 'Garzón', 'Municipio del centro del Huila con tradición cafetera', 13),

-- La Guajira
(61, 'Riohacha', 'Capital de La Guajira, centro de la cultura wayúu', 14),
(62, 'Maicao', 'Municipio fronterizo con Venezuela, centro comercial', 14),

-- Magdalena
(63, 'Santa Marta', 'Distrito turístico y patrimonio histórico nacional', 15),
(64, 'Ciénaga', 'Municipio bananero del sur del Magdalena', 15),
(65, 'Fundación', 'Municipio del centro del Magdalena', 15),

-- Meta
(66, 'Villavicencio', 'Capital del Meta, puerta de los llanos orientales', 16),
(67, 'Acacías', 'Municipio del piedemonte llanero', 16),
(68, 'Granada', 'Municipio del centro del Meta', 16),

-- Nariño
(69, 'Pasto', 'Capital de Nariño, ciudad universitaria andina', 17),
(70, 'Tumaco', 'Puerto del Pacífico con importante actividad pesquera', 17),
(71, 'Ipiales', 'Ciudad fronteriza con Ecuador', 17),

-- Norte de Santander
(72, 'Cúcuta', 'Capital fronteriza con Venezuela, centro comercial', 18),
(73, 'Ocaña', 'Municipio del centro-sur del Norte de Santander', 18),
(74, 'Villa del Rosario', 'Municipio metropolitano de Cúcuta', 18),
(75, 'Los Patios', 'Municipio del área metropolitana de Cúcuta', 18),

-- Putumayo
(76, 'Mocoa', 'Capital del Putumayo, puerta sur de la Amazonía', 19),
(77, 'Puerto Asís', 'Municipio del sur del Putumayo fronterizo con Ecuador', 19),

-- Quindío
(78, 'Armenia', 'Capital del Quindío, corazón del eje cafetero', 20),
(79, 'Calarcá', 'Municipio cafetero del Quindío', 20),
(80, 'La Tebaida', 'Municipio del occidente del Quindío', 20),
(81, 'Montenegro', 'Municipio cafetero y turístico del Quindío', 20),

-- Risaralda
(82, 'Pereira', 'Capital de Risaralda, centro tecnológico del eje cafetero', 21),
(83, 'Dosquebradas', 'Municipio metropolitano industrial de Pereira', 21),
(84, 'Santa Rosa de Cabal', 'Municipio termomedicinal y turístico', 21),

-- San Andrés y Providencia
(85, 'San Andrés', 'Isla principal del archipiélago, destino turístico caribeño', 22),
(86, 'Providencia', 'Isla del archipiélago con cultura raizal única', 22),

-- Santander
(87, 'Bucaramanga', 'Capital de Santander, ciudad bonita de Colombia', 23),
(88, 'Floridablanca', 'Municipio metropolitano de Bucaramanga', 23),
(89, 'Girón', 'Municipio colonial del área metropolitana', 23),
(90, 'Piedecuesta', 'Municipio del área metropolitana de Bucaramanga', 23),
(91, 'Barrancabermeja', 'Puerto petrolero sobre el río Magdalena', 23),
(92, 'San Gil', 'Capital turística de Santander', 23),

-- Sucre
(93, 'Sincelejo', 'Capital de Sucre, centro ganadero de la sabana', 24),
(94, 'Corozal', 'Municipio del centro de Sucre', 24),

-- Tolima
(95, 'Ibagué', 'Capital del Tolima, ciudad musical de Colombia', 25),
(96, 'Espinal', 'Municipio del centro del Tolima', 25),
(97, 'Melgar', 'Municipio turístico del Tolima', 25),
(98, 'Honda', 'Ciudad colonial a orillas del río Magdalena', 25),

-- Valle del Cauca
(99, 'Cali', 'Capital del Valle, capital mundial de la salsa', 26),
(100, 'Palmira', 'Municipio agroindustrial del centro del Valle', 26),
(101, 'Buenaventura', 'Principal puerto del Pacífico colombiano', 26),
(102, 'Tulúa', 'Municipio del centro del Valle del Cauca', 26),
(103, 'Cartago', 'Municipio del norte del Valle con tradición comercial', 26),
(104, 'Buga', 'Municipio religioso y agrícola del Valle', 26),
(105, 'Jamundí', 'Municipio del sur del área metropolitana de Cali', 26),
(106, 'Yumbo', 'Municipio industrial del área metropolitana de Cali', 26),

-- Arauca
(107, 'Arauca', 'Capital fronteriza con Venezuela', 27),

-- Amazonas
(108, 'Leticia', 'Capital del Amazonas, puerta de entrada a la selva', 28),

-- Guainía
(109, 'Inírida', 'Capital del Guainía, centro de la región de la Estrella Fluvial', 29),

-- Guaviare
(110, 'San José del Guaviare', 'Capital del Guaviare, puerta del Guaviare', 30),

-- Vaupés
(111, 'Mitú', 'Capital del Vaupés, centro de la cultura indígena amazónica', 31),

-- Vichada
(112, 'Puerto Carreño', 'Capital del Vichada, puerto fluvial fronterizo con Venezuela', 32),

-- Bogotá D.C.
(113, 'Bogotá', 'Capital de Colombia, centro político, económico y cultural del país', 33);

-- Insertar categorías completas
INSERT IGNORE INTO categories (id, name, description) VALUES 
(1, 'Apartamentos en Venta', 'Apartamentos disponibles para compra'),
(2, 'Apartamentos en Arriendo', 'Apartamentos disponibles para alquiler'),
(3, 'Casas en Venta', 'Casas independientes disponibles para compra'),
(4, 'Casas en Arriendo', 'Casas independientes disponibles para alquiler'),
(5, 'Oficinas', 'Espacios comerciales para oficinas'),
(6, 'Locales Comerciales', 'Espacios para actividades comerciales'),
(7, 'Lotes', 'Terrenos disponibles para construcción'),
(8, 'Fincas', 'Propiedades rurales y fincas'),
(9, 'Casas Campestres', 'Casas en zonas rurales y campestres'),
(10, 'Apartaestudios', 'Unidades pequeñas para estudiantes o solteros'),
(11, 'Penthouses', 'Apartamentos de lujo en últimos pisos'),
(12, 'Dúplex', 'Apartamentos de dos niveles'),
(13, 'Habitaciones', 'Habitaciones para alquiler compartido'),
(14, 'Bodegas', 'Espacios industriales y de almacenamiento'),
(15, 'Consultorios', 'Espacios para consultorios médicos y profesionales'),
(16, 'Hoteles', 'Propiedades hoteleras y turísticas'),
(17, 'Apartamentos Amoblados', 'Apartamentos completamente amueblados'),
(18, 'Casas Amobladas', 'Casas completamente amuebladas'),
(19, 'Parqueaderos', 'Espacios para parqueo de vehículos'),
(20, 'Edificios', 'Edificios completos para inversión o uso comercial');

-- Insertar ubicaciones (sectores) por ciudades principales
INSERT IGNORE INTO ubications (id, sector, city_id) VALUES 
-- Medellín (1)
(1, 'El Poblado', 1),
(2, 'Laureles', 1),
(3, 'Centro', 1),
(4, 'Belén', 1),
(5, 'Envigado', 1),
(6, 'Sabaneta', 1),
(7, 'La Estrella', 1),
(8, 'Buenos Aires', 1),
(9, 'La América', 1),
(10, 'Castilla', 1),

-- Bogotá (113)
(11, 'Zona Rosa', 113),
(12, 'Chapinero', 113),
(13, 'La Candelaria', 113),
(14, 'Usaquén', 113),
(15, 'Suba', 113),
(16, 'Engativá', 113),
(17, 'Kennedy', 113),
(18, 'Fontibón', 113),
(19, 'Teusaquillo', 113),
(20, 'Barrios Unidos', 113),
(21, 'Santa Fe', 113),
(22, 'San Cristóbal', 113),
(23, 'Ciudad Bolívar', 113),
(24, 'Bosa', 113),
(25, 'Puente Aranda', 113),

-- Cali (99)
(26, 'Centro Histórico', 99),
(27, 'Granada', 99),
(28, 'San Fernando', 99),
(29, 'Ciudad Jardín', 99),
(30, 'El Peñón', 99),
(31, 'Normandía', 99),
(32, 'Valle del Lili', 99),
(33, 'La Flora', 99),
(34, 'Tequendama', 99),
(35, 'Versalles', 99),

-- Barranquilla (11)
(36, 'Centro', 11),
(37, 'El Prado', 11),
(38, 'Riomar', 11),
(39, 'Villa Country', 11),
(40, 'Alto Prado', 11),
(41, 'Villa Santos', 11),
(42, 'La Concepción', 11),
(43, 'Boston', 11),

-- Cartagena (17)
(44, 'Centro Histórico', 17),
(45, 'Bocagrande', 17),
(46, 'Castillogrande', 17),
(47, 'Manga', 17),
(48, 'Getsemaní', 17),
(49, 'Crespo', 17),
(50, 'El Laguito', 17),
(51, 'La Matuna', 17),

-- Bucaramanga (87)
(52, 'Cabecera', 87),
(53, 'Centro', 87),
(54, 'García Rovira', 87),
(55, 'La Concordia', 87),
(56, 'Ciudadela Real de Minas', 87),
(57, 'Morrorico', 87),
(58, 'San Alonso', 87),

-- Pereira (82)
(59, 'Centro', 82),
(60, 'Circunvalar', 82),
(61, 'La Isla', 82),
(62, 'Villa Santana', 82),
(63, 'Pinares', 82),
(64, 'Cuba', 82),

-- Armenia (78)
(65, 'Centro', 78),
(66, 'Portal del Quindío', 78),
(67, 'La Patria', 78),
(68, 'Centenario', 78),
(69, 'Fundadores', 78),

-- Manizales (27)
(70, 'Centro', 27),
(71, 'Cable', 27),
(72, 'Versalles', 27),
(73, 'La Macarena', 27),
(74, 'Palogrande', 27),

-- Cúcuta (72)
(75, 'Centro', 72),
(76, 'Caobos', 72),
(77, 'La Playa', 72),
(78, 'Colsag', 72),
(79, 'Guaimaral', 72),

-- Santa Marta (63)
(80, 'Centro Histórico', 63),
(81, 'Rodadero', 63),
(82, 'Bello Horizonte', 63),
(83, 'Gaira', 63),
(84, 'Pozos Colorados', 63),

-- Villavicencio (66)
(85, 'Centro', 66),
(86, 'La Grama', 66),
(87, 'Buque', 66),
(88, 'Barzal', 66),
(89, 'Maizaro', 66),

-- Montería (42)
(90, 'Centro', 42),
(91, 'La Granja', 42),
(92, 'Villa Cielo', 42),
(93, 'P5', 42),

-- Pasto (69)
(94, 'Centro', 69),
(95, 'Fátima', 69),
(96, 'La Castellana', 69),
(97, 'Torobajo', 69),

-- Neiva (58)
(98, 'Centro', 58),
(99, 'Granjas', 58),
(100, 'Las Palmas', 58),
(101, 'Cándido', 58),

-- Valledupar (39)
(102, 'Centro', 39),
(103, 'La Paz', 39),
(104, 'Simón Bolívar', 39),

-- Ibagué (95)
(105, 'Centro', 95),
(106, 'Cadiz', 95),
(107, 'Ambalá', 95),
(108, 'La Pola', 95),

-- Popayán (36)
(109, 'Centro Histórico', 36),
(110, 'Norte', 36),
(111, 'Los Robles', 36),

-- Tunja (22)
(112, 'Centro', 22),
(113, 'Norte', 22),
(114, 'Sur', 22),

-- Sincelejo (93)
(115, 'Centro', 93),
(116, 'Majagual', 93),

-- Riohacha (61)
(117, 'Centro', 61),
(118, 'El Prado', 61),

-- Quibdó (56)
(119, 'Centro', 56),
(120, 'Yesca', 56),

-- Florencia (31)
(121, 'Centro', 31),
(122, 'Sur', 31),

-- Yopal (33)
(123, 'Centro', 33),
(124, 'La Campiña', 33),

-- Mocoa (76)
(125, 'Centro', 76),

-- San Andrés (85)
(126, 'Centro', 85),
(127, 'North End', 85),

-- Leticia (108)
(128, 'Centro', 108),

-- Inírida (109)
(129, 'Centro', 109),

-- San José del Guaviare (110)
(130, 'Centro', 110),

-- Mitú (111)
(131, 'Centro', 111),

-- Puerto Carreño (112)
(132, 'Centro', 112),

-- Arauca (107)
(133, 'Centro', 107);

-- Insertar casas de ejemplo para testing y demostración
INSERT IGNORE INTO houses (id, name, description, price, address, number_of_rooms, number_of_bathrooms, active_publication_date, publication_status, publication_date, seller_id, category_id, ubication_id) VALUES 
-- Apartamentos en El Poblado, Medellín (Categoría 1)
(1, 'Apartamento de Lujo El Poblado', 'Apartamento de 3 habitaciones con vista panorámica, acabados de lujo, parqueadero y depósito. Ubicado en el corazón de El Poblado cerca de centros comerciales y restaurantes.', 850000000, 'Carrera 43A #15-25, El Poblado', 3, 2, '2025-06-01', 'PUBLISHED', '2025-04-15', 2, 1, 1),
(2, 'Moderno Apartamento Zona Rosa', 'Apartamento contemporáneo de 2 habitaciones, cocina integral, balcón, gimnasio y piscina en el edificio. Excelente ubicación y transporte público.', 650000000, 'Calle 10 #43-18, El Poblado', 2, 2, '2025-06-02', 'PUBLISHED', '2025-04-16', 3, 1, 1),

-- Casas en Laureles, Medellín (Categoría 3)
(3, 'Casa Familiar Laureles', 'Casa de 4 habitaciones con jardín, garaje para 2 carros, sala comedor amplia y cocina equipada. Barrio tranquilo y seguro con todos los servicios.', 1200000000, 'Carrera 75 #45-123, Laureles', 4, 3, '2025-06-03', 'PUBLISHED', '2025-04-17', 4, 3, 2),
(4, 'Casa Esquinera Laureles', 'Casa esquinera de 3 habitaciones, 2 pisos, terraza, patio trasero y parqueadero. Ideal para familia pequeña, cerca de colegios y centros médicos.', 980000000, 'Calle 44B #76-45, Laureles', 3, 2, '2025-06-04', 'PUBLISHED', '2025-04-18', 5, 3, 2),

-- Apartamentos en Zona Rosa, Bogotá (Categoría 1)
(5, 'Penthouses Zona Rosa', 'Espectacular penthouse de 4 habitaciones con terraza privada, jacuzzi, cocina gourmet y 3 parqueaderos. Vista 360° de la ciudad.', 2500000000, 'Carrera 13 #85-32, Zona Rosa', 4, 4, '2025-06-05', 'PUBLISHED', '2025-04-19', 2, 11, 11),
(6, 'Apartamento Ejecutivo Chapinero', 'Apartamento de 2 habitaciones, estudio, balcón francés, acabados modernos. Edificio con portería 24/7, gimnasio y salón social.', 750000000, 'Calle 63 #11-45, Chapinero', 2, 2, '2025-06-06', 'PUBLISHED', '2025-04-20', 3, 1, 12),

-- Casas en Usaquén, Bogotá (Categoría 3)
(7, 'Casa Colonial Usaquén', 'Hermosa casa colonial de 5 habitaciones, biblioteca, chimenea, jardín con BBQ y garaje para 3 carros. Arquitectura tradicional restaurada.', 1800000000, 'Carrera 7 #116-28, Usaquén', 5, 3, '2025-06-07', 'PUBLISHED', '2025-04-21', 4, 3, 14),
(8, 'Casa Moderna Usaquén', 'Casa contemporánea de 3 habitaciones, cocina americana, sala de TV, terraza con jardín vertical y paneles solares. Construcción sostenible.', 1350000000, 'Calle 116 #15-67, Usaquén', 3, 3, '2025-06-08', 'PUBLISHED', '2025-04-22', 5, 3, 14),

-- Apartamentos en Granada, Cali (Categoría 2)
(9, 'Apartamento en Arriendo Granada', 'Apartamento amoblado de 2 habitaciones, aire acondicionado, cocina equipada, balcón con vista al río Cali. Incluye servicios públicos.', 2800000, 'Avenida 6 Norte #23-45, Granada', 2, 2, '2025-06-09', 'PUBLISHED', '2025-04-23', 2, 2, 27),
(10, 'Estudio Amoblado Centro Cali', 'Moderno apartaestudio completamente amoblado, cocina integral, baño completo, aire acondicionado. Ideal para profesionales o estudiantes.', 1500000, 'Carrera 5 #12-89, Centro', 1, 1, '2025-06-10', 'PUBLISHED', '2025-04-24', 3, 10, 26),

-- Casas en Ciudad Jardín, Cali (Categoría 3)
(11, 'Casa con Piscina Ciudad Jardín', 'Casa de 4 habitaciones, sala comedor, cocina integral, piscina, kiosco, garaje para 2 carros y cuarto de servicio. Excelente clima.', 1100000000, 'Calle 5 Oeste #25-14, Ciudad Jardín', 4, 3, '2025-06-11', 'PUBLISHED', '2025-04-25', 4, 3, 29),

-- Oficinas en Centro, Barranquilla (Categoría 5)
(12, 'Oficina Ejecutiva Centro', 'Oficina de 120 m² en edificio empresarial, 4 oficinas privadas, sala de juntas, recepción, 2 baños y 2 parqueaderos. Excelente ubicación comercial.', 450000000, 'Carrera 44 #35-78, Centro', 4, 2, '2025-06-12', 'PUBLISHED', '2025-04-26', 5, 5, 36),
(13, 'Oficina El Prado', 'Moderna oficina de 80 m², 3 oficinas, sala de espera, cocina, baño y parqueadero. Edificio con seguridad 24/7 y generador eléctrico.', 320000000, 'Calle 76 #52-123, El Prado', 3, 1, '2025-06-13', 'PUBLISHED', '2025-04-27', 2, 5, 37),

-- Locales Comerciales (Categoría 6)
(14, 'Local Comercial Bocagrande', 'Local comercial de 200 m² en primera planta, gran vitrina, 2 baños, bodega y parqueadero. Excelente flujo peatonal y turístico.', 800000000, 'Avenida San Martín #4-56, Bocagrande', 1, 2, '2025-06-14', 'PUBLISHED', '2025-04-28', 3, 6, 45),
(15, 'Local Centro Histórico Cartagena', 'Local colonial restaurado de 150 m², techos altos, ventilación natural, baño y acceso independiente. Ideal para restaurante o galería.', 650000000, 'Calle de la Moneda #33-18, Centro', 1, 1, '2025-06-15', 'PUBLISHED', '2025-04-29', 4, 6, 44),

-- Fincas (Categoría 8)
(16, 'Finca Cafetera Risaralda', 'Hermosa finca de 3 hectáreas con casa de 4 habitaciones, beneficiadero de café, establos, huerta orgánica y nacimiento de agua.', 580000000, 'Vereda La María, Santa Rosa de Cabal', 4, 2, '2025-06-16', 'PUBLISHED', '2025-04-30', 5, 8, 84),
(17, 'Finca Ganadera Meta', 'Finca de 25 hectáreas con casa principal de 3 habitaciones, galpones, establos, pozo profundo, pastos mejorados y ganado incluido.', 950000000, 'Vereda Apiay, Villavicencio', 3, 2, '2025-06-17', 'PUBLISHED', '2025-05-01', 2, 8, 85),

-- Lotes (Categoría 7)
(18, 'Lote Urbanizable Chía', 'Lote de 800 m² en conjunto cerrado, servicios públicos, vías pavimentadas, cerca al centro comercial. Ideal para casa de descanso.', 380000000, 'Conjunto Sabana Verde, Chía', 0, 0, '2025-06-18', 'PUBLISHED', '2025-05-02', 3, 7, 50),
(19, 'Lote Industrial Yumbo', 'Lote industrial de 2.000 m² con acceso directo a vía principal, servicios públicos instalados, cerca al puerto de Buenaventura.', 720000000, 'Zona Industrial Yumbo, Yumbo', 0, 0, '2025-06-19', 'PUBLISHED', '2025-05-03', 4, 7, 106),

-- Apartaestudios (Categoría 10)
(20, 'Apartaestudio Universitario Bucaramanga', 'Apartaestudio cerca a universidades, amoblado, cocina integral, baño completo, internet incluido. Ideal para estudiantes.', 180000000, 'Calle 42 #27-89, Cabecera', 1, 1, '2025-06-20', 'PUBLISHED', '2025-05-04', 5, 10, 52),

-- Casas Campestres (Categoría 9)
(21, 'Casa Campestre La Calera', 'Casa campestre de 3 habitaciones, chimenea, BBQ, jardín de 1.000 m², garaje y caballerizas. Clima frío, aire puro.', 650000000, 'Vereda Mundo Nuevo, La Calera', 3, 2, '2025-06-21', 'PUBLISHED', '2025-05-05', 2, 9, 48),
(22, 'Cabaña Turística Melgar', 'Cabaña de 2 habitaciones con piscina privada, kiosco, zona BBQ, aire acondicionado. Perfecta para alquiler turístico o descanso.', 420000000, 'Conjunto Las Palmeras, Melgar', 2, 2, '2025-06-22', 'PUBLISHED', '2025-05-06', 3, 9, 97),

-- Bodegas (Categoría 14)
(23, 'Bodega Industrial Fontibón', 'Bodega de 500 m² con oficina administrativa, 2 baños, rampa de carga, altura de 8 metros y parqueadero para tractomulas.', 680000000, 'Zona Industrial Fontibón, Bogotá', 1, 2, '2025-06-23', 'PUBLISHED', '2025-05-07', 4, 14, 18),

-- Propiedades con diferentes estados
(24, 'Apartamento Temporal Kennedy', 'Apartamento de 3 habitaciones en conjunto cerrado, parque infantil, salón comunal, portería 24/7. Temporalmente pausado para remodelación.', 420000000, 'Carrera 78 #42-15, Kennedy', 3, 2, '2025-06-24', 'PUBLICATION_PAUSED', '2025-05-08', 5, 1, 17),

-- Apartamentos de diferentes precios
(25, 'Apartamento Económico Suba', 'Apartamento de 2 habitaciones, sala comedor, cocina independiente, balcón, conjunto cerrado con zonas verdes. Excelente oportunidad.', 280000000, 'Carrera 91 #128-45, Suba', 2, 1, '2025-06-25', 'PUBLISHED', '2025-05-09', 2, 1, 15),
(26, 'Apartamento Premium Rosales', 'Exclusivo apartamento de 4 habitaciones, doble altura, terraza privada, 3 parqueaderos, depósito. Edificio boutique con pocas unidades.', 3200000000, 'Calle 70A #5-18, Rosales', 4, 4, '2025-06-26', 'PUBLISHED', '2025-05-10', 3, 1, 11),

-- Más propiedades en diferentes ciudades
(27, 'Casa Familiar Pereira', 'Casa de 3 habitaciones, patio, garaje, cerca a universidades y centros comerciales. Barrio tradicional y seguro de Pereira.', 380000000, 'Carrera 13 #18-67, Centro', 3, 2, '2025-06-27', 'PUBLISHED', '2025-05-11', 4, 3, 59),

(28, 'Apartamento Armenia Centro', 'Apartamento de 2 habitaciones en el centro de Armenia, cerca a la plaza de mercado y zona comercial. Ideal para inversión.', 250000000, 'Carrera 14 #18-23, Centro', 2, 1, '2025-06-28', 'PUBLISHED', '2025-05-12', 5, 1, 65),

-- Completando registros hasta 50 propiedades con más variedad

(29, 'Oficina Manizales Centro', 'Oficina profesional de 60 m², 2 oficinas privadas, recepción, baño, excelente iluminación natural. Edificio con ascensor y parqueadero.', 190000000, 'Carrera 23 #26-34, Centro', 2, 1, '2025-06-29', 'PUBLISHED', '2025-05-13', 2, 5, 68),

(30, 'Casa Turística Santa Marta', 'Casa de 4 habitaciones a 2 cuadras de la playa, terraza con vista al mar, aire acondicionado, garaje. Perfecta para alquiler turístico.', 680000000, 'Calle 22 #3-45, El Rodadero', 4, 3, '2025-06-30', 'PUBLISHED', '2025-05-14', 3, 3, 71),

-- Bodegas y espacios industriales
(31, 'Bodega Medellín Industrial', 'Bodega de 800 m² con oficina, 3 baños, patio de maniobras, altura de 10 metros. Zona industrial consolidada con excelente acceso vial.', 920000000, 'Carrera 50 #12-89, Itagüí', 1, 3, '2025-06-01', 'PUBLISHED', '2025-05-15', 4, 14, 6),

(32, 'Local Comercial Buenaventura', 'Local comercial esquinero de 180 m², gran vitrina, 2 niveles, baño, ideal para almacén o restaurante. Alto flujo vehicular y peatonal.', 350000000, 'Calle 2 #4-67, Centro', 2, 1, '2025-06-02', 'PUBLISHED', '2025-05-16', 5, 6, 104),

-- Fincas de recreo
(33, 'Finca Recreativa Guatapé', 'Finca de 2 hectáreas con casa de 3 habitaciones, piscina natural, senderos ecológicos, caballerizas. Vista espectacular al embalse.', 750000000, 'Vereda La Piedra, Guatapé', 3, 2, '2025-06-03', 'PUBLISHED', '2025-05-17', 2, 8, 4),

(34, 'Finca Agrícola Tolima', 'Finca productiva de 15 hectáreas con cultivos de arroz, casa de 4 habitaciones, bodegas, sistema de riego, maquinaria incluida.', 1200000000, 'Vereda El Placer, Espinal', 4, 2, '2025-06-04', 'PUBLISHED', '2025-05-18', 3, 8, 99),

-- Apartamentos en ciudades intermedias
(35, 'Apartamento Moderno Ibagué', 'Apartamento de 3 habitaciones, sala comedor, cocina integral, balcón, conjunto con piscina y gimnasio. Excelente ubicación.', 340000000, 'Carrera 5 #60-23, Ambalá', 3, 2, '2025-06-05', 'PUBLISHED', '2025-05-19', 4, 1, 88),

(36, 'Apartaestudio Popayán Centro', 'Apartaestudio amoblado cerca a universidades, cocina equipada, internet, servicios incluidos. Ideal para estudiantes o profesionales.', 220000000, 'Calle 4 #8-45, Centro', 1, 1, '2025-06-06', 'PUBLISHED', '2025-05-20', 5, 10, 75),

-- Casas de lujo
(37, 'Casa de Lujo La Calera', 'Mansión de 6 habitaciones, 5 baños, piscina climatizada, canchas múltiples, jacuzzi, caballerizas. Lote de 3.000 m².', 2800000000, 'Km 15 Vía La Calera, La Calera', 6, 5, '2025-06-07', 'PUBLISHED', '2025-05-21', 2, 3, 48),

(38, 'Casa Campestre Rionegro', 'Casa campestre de 5 habitaciones, 4 baños, chimenea, BBQ, jardín ornamental, garaje para 4 carros. Clima primavera todo el año.', 1800000000, 'Vereda Barro Blanco, Rionegro', 5, 4, '2025-06-08', 'PUBLISHED', '2025-05-22', 3, 9, 7),

-- Oficinas ejecutivas
(39, 'Oficina Premium World Trade Center', 'Oficina ejecutiva de 200 m² en WTC, 6 oficinas privadas, sala de juntas, recepción, 3 baños, 4 parqueaderos. Vista panorámica.', 1200000000, 'Calle 100 #8A-55, Bogotá', 6, 3, '2025-06-09', 'PUBLISHED', '2025-05-23', 4, 5, 11),

(40, 'Consultorio Médico Medellín', 'Consultorio de 80 m² en zona médica, 3 consultorios, sala de espera, baño, aire acondicionado. Edificio especializado en salud.', 380000000, 'Carrera 70 #52-18, Laureles', 3, 1, '2025-06-10', 'PUBLISHED', '2025-05-24', 5, 5, 2),

-- Lotes urbanos
(41, 'Lote Residencial Cajicá', 'Lote esquinero de 600 m² en conjunto cerrado, todos los servicios, vías pavimentadas, zona verde comunal. Ideal para casa familiar.', 420000000, 'Conjunto Hacienda Casablanca, Cajicá', 0, 0, '2025-06-11', 'PUBLISHED', '2025-05-25', 2, 7, 49),

(42, 'Lote Comercial Zipaquirá', 'Lote comercial de 1.200 m² sobre vía principal, ideal para centro comercial o supermercado. Todos los servicios públicos disponibles.', 680000000, 'Autopista Norte Km 45, Zipaquirá', 0, 0, '2025-06-12', 'PUBLISHED', '2025-05-26', 3, 7, 51),

-- Propiedades en arriendo
(43, 'Casa Arriendo Temporal Girardot', 'Casa de 3 habitaciones con piscina para arriendo por días o semanas, completamente amoblada, aire acondicionado, zona BBQ.', 4500000, 'Conjunto Villa del Sol, Girardot', 3, 2, '2025-06-13', 'PUBLISHED', '2025-05-27', 4, 3, 94),

-- Apartamentos en conjuntos cerrados
(44, 'Apartamento Conjunto Cerrado Floridablanca', 'Apartamento de 3 habitaciones en conjunto con piscina, gimnasio, salones sociales, canchas deportivas, portería 24/7.', 380000000, 'Carrera 27 #45-123, Cañaveral', 3, 2, '2025-06-14', 'PUBLISHED', '2025-05-28', 5, 1, 55),

(45, 'Apartamento Familiar Tunja', 'Apartamento de 2 habitaciones, calefacción, balcón cerrado, parqueadero cubierto. Conjunto con zonas verdes y juegos infantiles.', 280000000, 'Carrera 10 #18-45, Centro', 2, 2, '2025-06-15', 'PUBLISHED', '2025-05-29', 2, 1, 77),

-- Propiedades comerciales especializadas
(46, 'Restaurante Equipado Zona Rosa', 'Local comercial de 250 m² totalmente equipado para restaurante, cocina industrial, 2 baños, terraza, licencias al día.', 1500000000, 'Carrera 13 #82-45, Zona Rosa', 1, 2, '2025-06-16', 'PUBLISHED', '2025-05-30', 3, 6, 11),

(47, 'Hotel Boutique Centro Histórico', 'Edificio colonial de 3 pisos, 12 habitaciones, restaurante, recepción, completamente restaurado. Operando como hotel.', 3200000000, 'Calle del Arsenal #23-45, Cartagena', 12, 8, '2025-06-17', 'PUBLISHED', '2025-05-31', 4, 6, 44),

-- Propiedades con estado pausado
(48, 'Casa Remodelación El Poblado', 'Casa de 4 habitaciones en proceso de remodelación, excelente ubicación, proyecto arquitectónico aprobado. Inversión garantizada.', 1200000000, 'Calle 9 #42-67, El Poblado', 4, 3, '2025-06-18', 'PUBLICATION_PAUSED', '2025-05-01', 5, 3, 1),

-- Apartamentos económicos
(49, 'Apartamento VIS Bosa', 'Apartamento de interés social de 2 habitaciones, sala comedor, cocina, conjunto con parque infantil y salón comunal.', 180000000, 'Carrera 89 #65-23, Bosa', 2, 1, '2025-06-19', 'PUBLISHED', '2025-05-02', 2, 1, 16),

-- Propiedad de lujo final
(50, 'Penthouse Ultra Lujo Santa Marta', 'Penthouse de 300 m² con 4 habitaciones, terraza de 150 m², jacuzzi, vista al mar y Sierra Nevada, ascensor privado, 4 parqueaderos.', 4200000000, 'Carrera 1 #26-45, El Rodadero', 4, 5, '2025-06-20', 'PUBLISHED', '2025-05-03', 3, 1, 71);
