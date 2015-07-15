INSERT INTO `OP-i-Sports`.`tipo_servicio` (`id_tipo_servicio`, `tipo_servicio`) VALUES ('1', 'Futbol 5');
INSERT INTO `OP-i-Sports`.`tipo_servicio` (`id_tipo_servicio`, `tipo_servicio`) VALUES ('2', 'Basket Pavimento');
INSERT INTO `OP-i-Sports`.`tipo_servicio` (`id_tipo_servicio`, `tipo_servicio`) VALUES ('3', 'Paint Ball Trincheras');

INSERT INTO `OP-i-Sports`.`usuario` (`id_usuario`, `apellido`, `contrasenna`, `correo`, `nombre`, `nombre_usuario`, `telefono`) VALUES ('1', 'Lopez Ramirez', '12345678', 'llopezr@ucenfotec.ac.cr', 'Luis Esteban', 'llopezr', '29883910');
INSERT INTO `OP-i-Sports`.`usuario` (`id_usuario`, `apellido`, `contrasenna`, `correo`, `nombre`, `nombre_usuario`, `telefono`) VALUES ('2', 'Araica', '12345678', 'maraica', 'Mauricio', 'maraica', '12390840');
INSERT INTO `OP-i-Sports`.`usuario` (`id_usuario`, `apellido`, `contrasenna`, `correo`, `nombre`, `nombre_usuario`, `telefono`) VALUES ('3', 'Viales', '12345678', 'jviales', 'Juan', 'jvialesc', '23897198');
INSERT INTO `OP-i-Sports`.`usuario` (`id_usuario`, `apellido`, `contrasenna`, `correo`, `nombre`, `nombre_usuario`) VALUES ('4', 'Fernandez', '12345678', 'mfernandez', 'Mauricio', 'mfernandez');

INSERT INTO `OP-i-Sports`.`establecimiento_deportivo` (`id_establecimiento_deportivo`, `direccion`, `nombre`, `telefono`, `id_usuario`) VALUES ('1', 'Liberia', 'Soccer Center', '22222222', '3');
INSERT INTO `OP-i-Sports`.`establecimiento_deportivo` (`id_establecimiento_deportivo`, `direccion`, `nombre`, `telefono`, `id_usuario`) VALUES ('2', 'San Ramon', 'La Sabana', '22222222', '1');

INSERT INTO `OP-i-Sports`.`actividad_deportiva` (`id_actividad_deportiva`) VALUES ('1');

INSERT INTO `OP-i-Sports`.`servicio` (`id_servicio`, `arbitro`, `hora_apertura`, `hora_cierre`, `precio`, 
`servicio`, `id_actividad_deportiva`, `id_establecimiento`, `id_tipo_servicio`) 
VALUES ('1', '1', '8:00', '22:00', '10000', 'Cancha Sintetica', '1', '1', '1');
INSERT INTO `OP-i-Sports`.`servicio` (`id_servicio`, `arbitro`, `hora_apertura`, `hora_cierre`, `precio`,
`servicio`, `id_actividad_deportiva`, `id_establecimiento`, `id_tipo_servicio`) 
VALUES ('2', '1', '9:00', '23:00', '14000', 'Cancha Sintetica', '1', '1', '1');

INSERT INTO `OP-i-Sports`.`reservaciones` (`id_calendario`, `fecha`, `hora`, `ocurrencia`, `id_servicio`, `id_usuario`) VALUES ('7', '2015/07/17', '10:00', 'Siempre', '1', '4');
INSERT INTO `OP-i-Sports`.`reservaciones` (`id_calendario`, `fecha`, `hora`, `ocurrencia`, `id_servicio`, `id_usuario`) VALUES ('8', '2015/07/19', '15:00', 'No', '2', '3');
INSERT INTO `OP-i-Sports`.`reservaciones` (`id_calendario`, `fecha`, `hora`, `ocurrencia`, `id_servicio`, `id_usuario`) VALUES ('9', '2015/07/20', '14:00', 'No', '1', '2');
