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
