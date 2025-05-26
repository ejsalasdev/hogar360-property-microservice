-- Insertar los 32 departamentos de Colombia
INSERT INTO departments (id, name) VALUES 
(1, 'Antioquia'),
(2, 'Atlántico'),
(3, 'Bolívar'),
(4, 'Boyacá'),
(5, 'Caldas'),
(6, 'Caquetá'),
(7, 'Casanare'),
(8, 'Cauca'),
(9, 'Cesar'),
(10, 'Córdoba'),
(11, 'Cundinamarca'),
(12, 'Chocó'),
(13, 'Huila'),
(14, 'La Guajira'),
(15, 'Magdalena'),
(16, 'Meta'),
(17, 'Nariño'),
(18, 'Norte de Santander'),
(19, 'Putumayo'),
(20, 'Quindío'),
(21, 'Risaralda'),
(22, 'San Andrés y Providencia'),
(23, 'Santander'),
(24, 'Sucre'),
(25, 'Tolima'),
(26, 'Valle del Cauca'),
(27, 'Arauca'),
(28, 'Amazonas'),
(29, 'Guainía'),
(30, 'Guaviare'),
(31, 'Vaupés'),
(32, 'Vichada'),
(33, 'Bogotá D.C.');

-- Insertar ciudades principales por departamento
INSERT INTO cities (id, name, department_id) VALUES 
-- Antioquia
(1, 'Medellín', 1),
(2, 'Bello', 1),
(3, 'Itagüí', 1),
(4, 'Envigado', 1),
(5, 'Rionegro', 1),
(6, 'Sabaneta', 1),
(7, 'Apartadó', 1),
(8, 'Turbo', 1),
(9, 'Caucasia', 1),
(10, 'Copacabana', 1),

-- Atlántico
(11, 'Barranquilla', 2),
(12, 'Soledad', 2),
(13, 'Malambo', 2),
(14, 'Sabanalarga', 2),
(15, 'Galapa', 2),
(16, 'Puerto Colombia', 2),

-- Bolívar
(17, 'Cartagena', 3),
(18, 'Magangué', 3),
(19, 'Turbaco', 3),
(20, 'El Carmen de Bolívar', 3),
(21, 'Arjona', 3),

-- Boyacá
(22, 'Tunja', 4),
(23, 'Duitama', 4),
(24, 'Sogamoso', 4),
(25, 'Chiquinquirá', 4),
(26, 'Villa de Leyva', 4),

-- Caldas
(27, 'Manizales', 5),
(28, 'La Dorada', 5),
(29, 'Chinchiná', 5),
(30, 'Riosucio', 5),

-- Caquetá
(31, 'Florencia', 6),
(32, 'San Vicente del Caguán', 6),

-- Casanare
(33, 'Yopal', 7),
(34, 'Aguazul', 7),
(35, 'Villanueva', 7),

-- Cauca
(36, 'Popayán', 8),
(37, 'Santander de Quilichao', 8),
(38, 'Puerto Tejada', 8),

-- Cesar
(39, 'Valledupar', 9),
(40, 'Aguachica', 9),
(41, 'Bosconia', 9),

-- Córdoba
(42, 'Montería', 10),
(43, 'Cereté', 10),
(44, 'Sahagún', 10),
(45, 'Lorica', 10),

-- Cundinamarca
(46, 'Soacha', 11),
(47, 'Girardot', 11),
(48, 'Zipaquirá', 11),
(49, 'Facatativá', 11),
(50, 'Chía', 11),
(51, 'Mosquera', 11),
(52, 'Madrid', 11),
(53, 'Funza', 11),
(54, 'Cajicá', 11),
(55, 'Fusagasugá', 11),

-- Chocó
(56, 'Quibdó', 12),
(57, 'Istmina', 12),

-- Huila
(58, 'Neiva', 13),
(59, 'Pitalito', 13),
(60, 'Garzón', 13),

-- La Guajira
(61, 'Riohacha', 14),
(62, 'Maicao', 14),

-- Magdalena
(63, 'Santa Marta', 15),
(64, 'Ciénaga', 15),
(65, 'Fundación', 15),

-- Meta
(66, 'Villavicencio', 16),
(67, 'Acacías', 16),
(68, 'Granada', 16),

-- Nariño
(69, 'Pasto', 17),
(70, 'Tumaco', 17),
(71, 'Ipiales', 17),

-- Norte de Santander
(72, 'Cúcuta', 18),
(73, 'Ocaña', 18),
(74, 'Villa del Rosario', 18),
(75, 'Los Patios', 18),

-- Putumayo
(76, 'Mocoa', 19),
(77, 'Puerto Asís', 19),

-- Quindío
(78, 'Armenia', 20),
(79, 'Calarcá', 20),
(80, 'La Tebaida', 20),
(81, 'Montenegro', 20),

-- Risaralda
(82, 'Pereira', 21),
(83, 'Dosquebradas', 21),
(84, 'Santa Rosa de Cabal', 21),

-- San Andrés y Providencia
(85, 'San Andrés', 22),
(86, 'Providencia', 22),

-- Santander
(87, 'Bucaramanga', 23),
(88, 'Floridablanca', 23),
(89, 'Girón', 23),
(90, 'Piedecuesta', 23),
(91, 'Barrancabermeja', 23),
(92, 'San Gil', 23),

-- Sucre
(93, 'Sincelejo', 24),
(94, 'Corozal', 24),

-- Tolima
(95, 'Ibagué', 25),
(96, 'Espinal', 25),
(97, 'Melgar', 25),
(98, 'Honda', 25),

-- Valle del Cauca
(99, 'Cali', 26),
(100, 'Palmira', 26),
(101, 'Buenaventura', 26),
(102, 'Tulúa', 26),
(103, 'Cartago', 26),
(104, 'Buga', 26),
(105, 'Jamundí', 26),
(106, 'Yumbo', 26),

-- Arauca
(107, 'Arauca', 27),

-- Amazonas
(108, 'Leticia', 28),

-- Guainía
(109, 'Inírida', 29),

-- Guaviare
(110, 'San José del Guaviare', 30),

-- Vaupés
(111, 'Mitú', 31),

-- Vichada
(112, 'Puerto Carreño', 32),

-- Bogotá D.C.
(113, 'Bogotá', 33);

-- Insertar categorías completas
INSERT INTO categories (id, name, description) VALUES 
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
INSERT INTO ubications (id, sector, city_id) VALUES 
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
