package com.tfg.Servicio_frontend.servicio.mock;

import com.tfg.Servicio_frontend.dto.AnuncioDto;
import com.tfg.Servicio_frontend.dto.AnuncioInmobiliarioDto;
import com.tfg.Servicio_frontend.dto.AnuncioMotoDto;
import com.tfg.Servicio_frontend.servicio.AnuncioServicio;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class MockAnuncioServicio implements AnuncioServicio {
    private final List<AnuncioDto> anuncios = new ArrayList<>();

    @PostConstruct
    public void init(){
        Random random = new Random();

        // Generación de datos mock para la categoría motor
        anuncios.add(createMotor("id"+random.nextInt(100),"Suzuki GS500 2007","Suzuki","GS500",1450.0,62000,true,"Valencia","Suzuki GS500 2007 (Etiqueta C)\n" +
                "\n" +
                "Moto con 115.000km, carburación, ITV hasta noviembre del 2027.\n" +
                "\n" +
                "Detalles importantes:\n" +
                "\n" +
                "- Moto que pierde aceite por el retén del piñón de ataque\n" +
                "\n" +
                "- Quema MUCHO aceite, hay que tenerlo en cuenta (revisar el nivel en cada depósito de gasolina)\n" +
                "\n" +
                "- Tiene una caída del lado izquierdo (Depósito, tensor de la maneta del embrague, Faro, carenado trasero y tacómetro rascados).\n" +
                "\n" +
                "- Depósito oxidado por dentro.\n" +
                "\n" +
                "- Intermitentes dinámicos (puedo entregar los originales)\n" +
                "\n" +
                "Moto con MUCHO trabajo por delante, se usa de diario para ir a trabajar, pero no es una moto de conducir y olvidarte.\n" +
                "\n" +
                "Preguntar sin compromiso.","https://es.wallapop.com/item/suzuki-gs500-azul-y-blanca-1263198647","https://cdn.wallapop.com/images/10420/kw/2q/__/c10420p1263198647/i6502958715.jpg?pictureSize=W640"));

        anuncios.add(createMotor("id"+random.nextInt(100),"Suzuki GS500E","Suzuki","GS500",1800.0,41000,true,"Madrid","Moto Suzuki GS500E Slingshot del año 1989 primera serie Japonesa\n" +
                "Tiene una averia,pica algo interno en el motor\n" +
                "La tengo desde el 2019 y siempre la he cuidado muy bien\n" +
                "-neumaticos Battlax hupersport s22\n" +
                "-cupula puig azul\n" +
                "-kit transmision a estrenar\n" +
                "-pintada blanco perla\n" +
                "-manillar Rizoma\n" +
                "Tengo 2 motores, compre otro y se lo cambie pero tambien picaba\n" +
                "Habria que hacerle retenes de horquillas tambien","https://es.wallapop.com/item/suzuki-gs500e-slingshot-1989-1270099023","https://cdn.wallapop.com/images/10420/l0/6m/__/c10420p1270099023/i6546314217.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Suzuki GS500 limitada A2","Suzuki","GS500",2200.0,35000,true,"Sevilla","En venta Suzuki GS500 limitada (tengo las campanas para cuando se deslimite).\n" +
                "Etiqueta medioambiental B.\n" +
                "Manual del propietario.\n" +
                "\n" +
                "La compró en enero del 24 mi hija para el A2 y ha desistido porque no hay manera de que apruebe...\n" +
                "\n" +
                "Hace 2 años se hicieron un montón de cosas además de los mantenimientos básicos. En la última foto está todo.\n" +
                "\n" +
                "En marzo de este año le hice todos los mantenimientos nuevamente, (no por kilómetros, si por tiempo). ITV también (sin defectos).\n" +
                "\n" +
                "Sacas el seguro y a correr, tiene medio depósito de gasolina...","https://es.wallapop.com/item/suzuki-gs500-limitada-1269989562","https://cdn.wallapop.com/images/10420/l0/4a/__/c10420p1269989562/i6545626285.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Honda CB500F 2016","Honda","CB500F",4200.0,28000,true,"Madrid","Honda CB500F del 2016 con 80.000 km, muy cuidada y siempre mantenida al día. Único propietario, siempre en garaje individual. Consumo (3,5l).\n" +
                "Perfecta tanto para ciudad como para carretera, ideal como primera moto grande o para uso diario.\n" +
                "\n" +
                "✔ Neumáticos Michelin Road 6\n" +
                "✔ Cadena reforzada serie oro\n" +
                "✔ Baúl Shad de 48L (entran 2 cascos integrales)\n" +
                "✔ Revisiones y mantenimiento siempre al día (Con factura demostable)\n" +
                "#Acepto cambio por Honda Forza 125cc, 350cc o tipo scooter similar.\n" +
                "Moto lista para rodar sin necesidad de hacerle nada.\n" +
                "Se puede ver/probar sin compromiso.","https://es.wallapop.com/item/honda-cb500f-881126076","https://cdn.wallapop.com/images/10420/ek/ll/__/c10420p881126076/i3178334151.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Honda CB500F ABS","Honda","CB500F",3900.0,34000,true,"Valencia","Moto Honda CB500F en color azul y negro. Perfecta para iniciarse en el carnet A2.\n" +
                "Año: 2018\n" +
                "Km: 12.500\n" +
                "ITV recién pasada hasta Mayo de 2028\n" +
                "Todas las revisiones al día en centros oficiales honda.\n" +
                "Incluye defensas del motor y toma de 12V para cargar el móvil.\n" +
                "Como nueva como se aprecia en las fotos siempre guardada en garaje, únicamente tiene una pieza rota, que se puede ver en la última foto, que no influye para nada en su funcionamiento.\n" +
                "Se puede ver sin compromiso.\n" +
                "Se aceptan pruebas mecánicas.\n" +
                "Vendo por no usar.","https://es.wallapop.com/item/honda-cb500f-naked-azul-y-negra-1262704526","https://cdn.wallapop.com/images/10420/kv/s5/__/c10420p1262704526/i6500070582.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Honda CB500F 2018","Honda","CB500F",4800.0,18000,true,"Barcelona","Moto Honda CB500F del año 2018 con un diseño llamativo.\n" +
                "\n" +
                "- Estilo naked.\n" +
                "- Transmisión manual.\n" +
                "Con tan solo 38.272km bien cuidada me acabo de sacar el carnet A y quiero cambiar a algo mas grande tipo cb650r o cbr650r","https://es.wallapop.com/item/honda-cb500f-2018-plata-amarillo-1257892957","https://cdn.wallapop.com/images/10420/ks/x0/__/c10420p1257892957/i6466845847.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Honda CBF500","Honda","CBF500",2500.0,52000,true,"Murcia","Moto Honda CBF500 2006\n" +
                "- Cúpula Givi alta\n" +
                "- Baúl trasero dos cascos\n" +
                "- Toma USB\n" +
                "- Frenos ABS.\n" +
                "- Gomas en perfecto estado\n" +
                "- Pastillas de freno pocos km\n" +
                "- Aceite y filtros recién cambiados\n" +
                "- ITV Julio 2027\n" +
                "- Etiqueta B\n" +
                "- Limitada A2 (*)\n" +
                "Se usa a diario para ir al trabajo\n" +
                "Cosas de la edad pero en muy buen estado\n" +
                "Lista para salir rodando, no tienes que hacer nada en los próximos 6000 kms (Próximo camino de aceite)\n" +
                "El precio es el que es, no se regatea\n" +
                "No cambios","https://es.wallapop.com/item/honda-cbf500-abs-1263042936","https://cdn.wallapop.com/images/10420/kv/ze/__/c10420p1263042936/i6502161905.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Honda CBF500 impecable","Honda","CBF500",2700.0,47000,true,"Zaragoza","Moto Honda CBF500 en colores rojo y negro.\n" +
                "\n" +
                "- Estilo naked.\n" +
                "- Transmisión manual.","https://es.wallapop.com/item/honda-cbf500-naked-roja-y-negra-1255286369","https://cdn.wallapop.com/images/10420/kr/d5/__/c10420p1255286369/i6452094568.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Kawasaki ER-5","Kawasaki","ER5",1600.0,71000,true,"Madrid","Moto Kawasaki ER5 de color azul.\n" +
                "año 2006, etiqetq B , itv hasta agosto, limitada para el a2, revisiones al dia, escucho ofertas\n" +
                "- Estilo naked.\n" +
                "- Transmisión manual.","https://es.wallapop.com/item/kawasaki-er5-azul-1272202639","https://cdn.wallapop.com/images/10420/l1/fp/__/c10420p1272202639/i6559309045.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Kawasaki ER-5 limitada","Kawasaki","ER5",1950.0,48000,true,"Bilbao","Moto Kawasaki ER-5 del año 1999, con la limitación para el carnet A2. Un modelo naked con caja de cambios manual.\n" +
                "\n" +
                "- Limitada para el carnet A2.\n" +
                "- Estilo naked.\n" +
                "- Baúl kappa de 40 litros\n" +
                "50.000km. ITV hasta octubre de 2027. Cubiertas nuevas y escape nuevo GPR homologado. Revisada de todo.","https://es.wallapop.com/item/kawasaki-er-5-a2-limitada-1999-roja-1236727331","https://cdn.wallapop.com/images/10420/kg/bc/__/c10420p1236727331/i6333743144.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Kawasaki ER-5 2006","Kawasaki","ER5",1750.0,65000,true,"Valencia","Matriculada el 21/07/2006, 39.000km. 500cc. Para uso con carné A o A2. Ruedas al 80%. Batería nueva y revisión recien hecha. Itv recién pasada (Hasta julio de 2027). Top case incluido. Se vende por no poder usar. Sólo arrancar y hacer kilómetros.","https://es.wallapop.com/item/kawasaki-er5-1132636746","https://cdn.wallapop.com/images/10420/iq/cc/__/c10420p1132636746/i5649333236.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Yamaha MT-03 2019","Yamaha","MT03",4700.0,15000,true,"Barcelona","12.000km","https://es.wallapop.com/item/yamaha-mt-03-2019-883767449","https://cdn.wallapop.com/images/10420/em/67/__/c10420p883767449/i3194520302.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Yamaha MT-03 ABS","Yamaha","MT03",5100.0,12000,true,"Madrid","Moto Yamaha MT-03 con ABS.\n" +
                "\n" +
                "- Color negro, gris y detalles en rojo.\n" +
                "- Parabrisas negro.\n" +
                "-Matriculada en 2020,\n" +
                "-321cc. 42cv. Carnet A2\n" +
                "-Ni un rasguño sólo tiene 4000km, la vendo porque la uso muy poco, está como nueva.\n" +
                "-Tiene anticaidas Puig, protector de radiador, cúpula, protector del tablero, etc.\n" +
                "-Duerme adentro y tapada, revisión hecha.\n" +
                "-ITV hasta 2028.\n" +
                "La he cuidado mucho y usado muy poco, está impecable.\n" +
                "Precio No negociable.","https://es.wallapop.com/item/yamaha-mt-03-abs-3900km-1177845639","https://cdn.wallapop.com/images/10420/jh/9b/__/c10420p1177845639/i5946135503.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Yamaha MT-03 negra","Yamaha","MT03",4500.0,22000,true,"Málaga","Yamaha MT-03 con 15.000 kms con mantenimientos al día e ITV pasada, se vende por poco uso, la moto ideal para el carnet A2\n" +
                "Precio negociable","https://es.wallapop.com/item/yamaha-mt-03-negra-1270662635","https://cdn.wallapop.com/images/10420/l0/ip/__/c10420p1270662635/i6549356943.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"KTM Duke 390","KTM","Duke390",4200.0,24000,true,"Valencia","Ktm duke 390 4000 km de noviembre 2025.1° Revisión hecha en casa. Duerme en garaje. Regalo casco recién estrenado. Dispone de gps, abs con posibilidad de desactivar el trasero. Modo conducción lluvia. Conectividad con movil para música, llamadas y radares. Tiene quickshifter. Para no apretar embrague ni reduciendo ni acelerando. Cambias sin soltar puño.garantia 3 años desde nov 2025\n" +
                "También regalo cúpula corta. Casi el 100% de los km hechos en autovia. Consumo real 3.7 a 95km/h","https://es.wallapop.com/item/ktm-duke-390-naranja-1232449416","https://cdn.wallapop.com/images/10420/kd/ro/__/c10420p1232449416/i6304379869.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"KTM Duke 390 ABS","KTM","Duke390",4600.0,17000,true,"Barcelona","Moto KTM Duke 390 del año 2015 con ABS.\n" +
                "Vendo o cambio por Custom.\n" +
                "-16.367 Km\n" +
                "-ITV hasta 2027 y recién revisada\n" +
                "-Topes anticaída y defensas\n" +
                "- Aceite, filtros y kit de arrastre con 0km recién cambiado.\n" +
                "- Neumáticos al 80%\n" +
                "-Manual de la casa KTM\n" +
                "-Herramientas originales de KTM","https://es.wallapop.com/item/ktm-duke-390-abs-2015-1249905196","https://cdn.wallapop.com/images/10420/ko/5t/__/c10420p1249905196/i6418362078.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"KTM Duke 390 2020","KTM","Duke390",5100.0,11000,true,"Madrid","Moto KTM 390 Duke en llamativo diseño naranja y blanco.\n" +
                "-escapa ORIGINAL HOMOLOGADO akrapovic\n" +
                "-supresor de catalizador mivv\n" +
                "- Estilo naked deportivo.\n" +
                "- Transmisión manual.\n" +
                "Vinilada con bastantes extras, mejor ver","https://es.wallapop.com/item/ktm-390-duke-naked-17000km-del-2020-1257020496","https://cdn.wallapop.com/images/10420/ks/eb/__/c10420p1257020496/i6461756791.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"BMW G310R","BMW","G310R",4300.0,20000,true,"Bilbao","Moto BMW G310R en color blanco con detalles en azul y rojo.\n" +
                "\n" +
                "- Mantenimiento en servicio oficial\n" +
                "- Diseño deportivo.\n" +
                "- Estilo naked\n" +
                "- revisión recién hecha\n" +
                "-neumaticos en buen estado\n" +
                "-14000km\n" +
                "- del 26 de noviembre de 2020","https://es.wallapop.com/item/bmw-g310r-1246765789","https://cdn.wallapop.com/images/10420/km/ai/__/c10420p1246765789/i6397260639.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"BMW G310R 2021","BMW","G310R",4900.0,9000,true,"Valencia","Moto BMW G310R del año 2021. Actualmente tiene casi 9000 KM. Siempre ha dormido en garaje personal. Muy buena moto para empezar en el carnet A2, ligera y con una muy buena potencia de 34 CV.\n" +
                "Incluye linea conpleta de MIVV valorada en 300€ y tubo de escape original.\n" +
                "Revision pasada y ITV pasada en mayo.\n" +
                "Vendo por cambio de cilindrada. Precio negociable","https://es.wallapop.com/item/bmw-g310r-2021-1093339062","https://cdn.wallapop.com/images/10420/i2/y1/__/c10420p1093339062/i5742904738.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"BMW G310R Full Equip","BMW","G310R",5200.0,7000,true,"Madrid","Moto BMW G310R en perfecto estado.\n" +
                "Válida para carnet A o A2.\n" +
                "ITV en vigor.\n" +
                "Cadena y batería recién cambiadas.\n" +
                "Año 2019\n" +
                "23.500 km\n" +
                "345 kg\n" +
                "313 cc\n" +
                "Cuenta con maleta trasera que se puede poner y quitar.","https://es.wallapop.com/item/bmw-g310r-moto-impecable-1155126866","https://cdn.wallapop.com/images/10420/j3/qd/__/c10420p1155126866/i5813211636.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Benelli TRK 502","Benelli","TRK502",4900.0,26000,true,"Sevilla","Moto Benelli TRK 502X en excelente estado, lista para la aventura.\n" +
                "32200km\n" +
                "Año 2019\n" +
                "Itv hasta agosto del 2027\n" +
                "Cambios de aceite hechos y recien revisada.\n" +
                "Muy cuidada duerme siempre en garaje\n" +
                "Muchos extras","https://es.wallapop.com/item/benelli-trk-502x-adventure-moto-1246563434","https://cdn.wallapop.com/images/10420/km/66/__/c10420p1246563434/i6396000430.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Benelli TRK 502 Touring","Benelli","TRK502",5500.0,18000,true,"Murcia","Benelli TRK 502X 2019 muy cuidada y equipada, 20.000 km. Siempre en garaje y mantenimientos e ITV al día.\n" +
                "\n" +
                "Última revisión con 17.000 km, bujías Iridium doble electrodo, Motul 7100, Filtro altoflujo BMC, Batería lithio, Kit de arrastre DID reforzado 1.000 km y neumáticos Mitas Touring Force 2.000 km.","https://es.wallapop.com/item/benelli-trk-502x-2019-1262740571","https://cdn.wallapop.com/images/10420/kv/sw/__/c10420p1262740571/i6501511595.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Benelli TRK 502 X","Benelli","TRK502",5900.0,12000,true,"Madrid","Moto Zontes U1 ZT 125cc estilo naked.\n" +
                "\n" +
                "- Diseño moderno y deportivo.\n" +
                "- Alarma y bloqueo de seguridad.\n" +
                "- Llave de proximidad y arranque. ( 2 juegos de llaves )\n" +
                "- Ruedas de aleación con diseño deportivo.\n" +
                "- Iluminación LED.\n" +
                "- Frenos ABS.\n" +
                "La moto la compré para mi hijo y alfinal no sé sacó el carnet y la fui usando esporádicamente. La vendo porque apenas se usa. La moto está como nueva, mejor ver y probar.\n" +
                "También cambio por Benelli TRK502X más diferencia en efectivo.Se puede negociar.","https://es.wallapop.com/item/zontes-u1-zt-125cc-naked-negra-1266665941","https://cdn.wallapop.com/images/10420/ky/51/__/c10420p1266665941/i6523646829.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Royal Enfield Himalayan","Royal Enfield","Himalayan",4300.0,25000,true,"Valencia","ROYAL ENFIELD HIMALAYAN 452\n" +
                "- Fecha de matriculación: 10/12/2024\n" +
                "- Kilómetros: 1.139\n" +
                "- Equipamiento/Extras:\n" +
                "\n" +
                "- Totalmente revisada.\n" +
                "- Garantía: Oficial hasta 11/05/2027.\n" +
                "- Cilindrada: 451cc.\n" +
                "- Potencia: 29.4kw, 40cv.","https://es.wallapop.com/item/royal-enfield-himalayan-452-1261584069","https://cdn.wallapop.com/images/10420/kv/44/__/c10420p1261584069/i6492894918.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Royal Enfield Himalayan 2022","Royal Enfield","Himalayan",5200.0,8000,true,"Barcelona","ROYAL ENFIELD HIMALAYAN\n" +
                "Año: 2022\n" +
                "Kilómetros: 1692","https://es.wallapop.com/item/royal-enfield-himalayan-1262078391","https://cdn.wallapop.com/images/10420/kv/ep/__/c10420p1262078391/i6495879247.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Royal Enfield Scram 411","Royal Enfield","Scram411",4700.0,14000,true,"Sevilla","ROYAL ENFIELD SCRAM 411\n" +
                "• Extras: ABS, Para manos , Cubre carter\n" +
                "• KM: 1465\n" +
                "• Año: 2023\n" +
                "• Garantía Cüimo: 1 año ampliable\n" +
                "• Garantía del fabricante hasta 05 April 2026\n" +
                "• Carnet: A, A2\n" +
                "\n" +
                "CERTIFICADA: moto totalmente revisada con informe. Visita la web para ver cualquier desperfecto.\n" +
                "\n" +
                "Entrega tu moto como parte de pago.\n" +
                "\n" +
                "La mayor exposición de motos de Madrid, al alcance de toda España.","https://es.wallapop.com/item/royal-enfield-scram-411-1265754762","https://cdn.wallapop.com/images/10420/kx/li/__/c10420p1265754762/i6518054953.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Voge 500R","Voge","500R",3900.0,23000,true,"Madrid","Moto Voge 500R en color gris y plata, modelo del 2021.\n" +
                "\n" +
                "- Estilo naked.\n" +
                "- Transmisión manual.\n" +
                "- 18.000 km","https://es.wallapop.com/item/moto-voge-500r-naked-gris-plata-2021-1268746800","https://cdn.wallapop.com/images/10420/kz/dn/__/c10420p1268746800/i6537209296.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"Voge 500DS","Voge","500DS",4800.0,30000,true,"Valencia","Moto Voge 500ac en perfecto estado, con un diseño naked y una combinación de colores azul y marrón.\n" +
                "\n" +
                "- Moto en perfecto estado.\n" +
                "- Estilo naked.\n" +
                "- Cambio manual.","https://es.wallapop.com/item/voge-500ac-naked-azul-marron-1253750470","https://cdn.wallapop.com/images/10420/kq/g8/__/c10420p1253750470/i6442990812.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"CFMoto 450 NK","CFMoto","450NK",5400.0,6000,true,"Barcelona","Vendo mi CFMOTO 450 NK matriculada en junio de 2024, una naked moderna, agresiva y súper divertida de conducir. Moto prácticamente nueva, muy cuidada y siempre en garaje.\n" +
                "\n" +
                "⚡ Motor bicilíndrico con una respuesta brutal\n" +
                "⚡ Estética radical y sonido espectacular\n" +
                "⚡ Muy cómoda tanto para ciudad como carretera\n" +
                "⚡ Consumo bajo y mantenimiento económico\n" +
                "⚡ Ideal para A2\n" +
                "\n" +
                "\uD83D\uDD27 Se entrega con:\n" +
                "\n" +
                "* Revisiones oficiales selladas\n" +
                "* Documentación al día","https://es.wallapop.com/item/cfmoto-450-nk-como-nueva-1270853835","https://cdn.wallapop.com/images/10420/l0/mt/__/c10420p1270853835/i6551048227.jpg?pictureSize=W640"));
        anuncios.add(createMotor("id"+random.nextInt(100),"CFMoto 450MT","CFMoto","450MT",6500.0,1500,true,"Madrid","Moto CFMOTO 450 MT en alquiler por libre 70€ día seguro incluido.\n" +
                "- Fianza de 300€\n" +
                "- Ruta guiada de 4 horas 120€\n" +
                "- Déjate sorprender por la 450MT\n" +
                "- Diseño aventurero y robusto.\n" +
                "- Parabrisas ajustable.\n" +
                "- Neumáticos mixtos para carretera y caminos.\n" +
                "@mundo_overland2023 (Instagram)\n" +
                "mundoverland.com (web)\n" +
                "#honda #yamaha #suzuki #kawasaki #bmw #ducati #cfmoto #voge #qjmotor #benelli #rieju #zontes","https://es.wallapop.com/item/moto-cfmoto-450-mt-1203709638","https://cdn.wallapop.com/images/10420/jw/no/__/c10420p1203709638/i6118433194.jpg?pictureSize=W640"));

        // Generación de datos mock para la categoría inmobiliario
        anuncios.add(createEstate("id"+random.nextInt(100),"Piso reformado centro Valencia","Piso",599000.0,85,"Valencia","Exclusivo dúplex en el corazón del casco histórico de Valencia\n" +
                "\n" +
                "¿Buscas una vivienda única en una ubicación privilegiada? Te presentamos este espectacular dúplex totalmente reformado, situado a escasos metros de la Plaza de la Reina, la Plaza de la Virgen y la Seu. Una oportunidad irrepetible para vivir en una de las zonas más emblemáticas de la ciudad.\n" +
                "\n" +
                "Distribución perfecta en dos plantas:\n" +
                "Planta inferior:\n" +
                "- Luminoso salón-comedor con balcones a la calle principal\n" +
                "- Cocina abierta, moderna y totalmente equipada\n" +
                "- 1 amplia habitación doble\n" +
                "- 1 baño completo de gran tamaño con doble lavabo\n" +
                "\n" +
                "Planta superior:\n" +
                "- 2 habitaciones dobles\n" +
                "- Dormitorio principal con baño en suite\n" +
                "- Características destacadas:\n" +
                "- Vivienda totalmente reformada con excelentes calidades\n" +
                "- Gran luminosidad gracias a su orientación este-oeste\n" +
                "- Espacios amplios y bien distribuidos\n" +
                "- Encanto histórico combinado con diseño moderno\n" +
                "\n" +
                "Ubicación inmejorable: Vive rodeado de historia, cultura, comercios, gastronomía y todos los servicios, en pleno centro de Valencia.\n" +
                "\n" +
                "Una vivienda que lo tiene todo: ubicación, diseño, confort y exclusividad.\n" +
                "\n" +
                "No dejes pasar esta oportunidad. ¡Ven a visitarlo y enamórate!\n" +
                "La oferta está sujeta a cambios de precio o retirada del mercado sin previo aviso. El precio no incluye lo siguiente:\n" +
                "- Honorarios de la agencia inmobiliaria\n" +
                "- Impuestos ( IVA, ITP, IAJD) Plusvalía, tasación bancaria, notaria, gestoría y registro.\n" +
                "\n" +
                "Llámanos hoy mismo para recibir más información.","https://es.wallapop.com/item/piso-en-venta-en-la-seu-en-valencia-1270748989","https://cdn.wallapop.com/images/10420/l0/kk/__/c10420p1270748989/i6550074882.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Piso junto a universidad","Piso",350000.0,78,"Valencia"," Vivienda en pleno Barrio del Carmen - Valencia\n" +
                "Magnífica vivienda situada en una tercera altura con ascensor, en finca exclusiva de solo 5 vecinos (una vivienda por planta), que garantiza tranquilidad y privacidad.\n" +
                "La vivienda destaca por ser muy luminosa y por su excelente distribución sin pasillos, aprovechando al máximo cada metro cuadrado.\n" +
                "✨ Características principales:\n" +
                "2 habitaciones dobles con armarios empotrados\n" +
                "Ventiladores de techo en dormitorios\n" +
                "Aire acondicionado en salón-comedor y habitación principal\n" +
                "Amplio salón-comedor con pequeño balcón\n" +
                "Cocina independiente totalmente equipada\n" +
                "Finca con ascensor\n" +
                "� Ubicación inmejorable, a un paso de las Torres de Quart, rodeada de comercios, supermercados y muy próxima a la Universidad Católica de Valencia.\n" +
                "Una oportunidad ideal tanto para vivir como para invertir en una de las zonas con más encanto de Valencia.\n" +
                "� Para más información, contacta con Inmocity Expertos Inmobiliarios.\n" +
                "Te conseguimos la financiación hasta el 100% en algunos casos.","https://es.wallapop.com/item/piso-en-venta-en-el-carme-en-valencia-1268865906","https://cdn.wallapop.com/images/10420/kz/g7/__/c10420p1268865906/i6538540621.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Ático con terraza","Ático",690000.0,95,"Valencia","Ubicado en la calle Roger de Lauria, en pleno barrio de San Francesc, se presenta este exclusivo ático en una de las ubicaciones más privilegiadas y cotizadas del centro de Valencia. Un enclave excepcional que permite disfrutar de la vida urbana con todos los servicios, comercios, restaurantes, zonas culturales y conexiones de transporte a escasos pasos de la vivienda, en el corazón de la ciudad. La propiedad se sitúa en la séptima planta con ascensor de un elegante edificio modernista rehabilitado integralmente en 2001, combinando el carácter arquitectónico de la Valencia histórica con las comodidades propias de una rehabilitación contemporánea. Cuenta con 80 m² construidos según catastro y una magnífica terraza privada de 15 m² orientada al este, un espacio privilegiado para disfrutar de la luz natural durante toda la mañana y crear una agradable zona exterior en pleno centro urbano.","https://es.wallapop.com/item/atico-en-venta-en-sant-francesc-en-valencia-1272251885","https://cdn.wallapop.com/images/10420/l1/gr/__/c10420p1272251885/i6559643829.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Casa adosada","Casa",750000.0,140,"Valencia","Adosado en Valencia con amplios espacios y excelente distribución. La vivienda dispone de jardín privado, cocina independiente y luminoso comedor con chimenea. Cuenta además con una agradable terraza con barbacoa ideal para disfrutar al aire libre.\n" +
                "\n" +
                "En la planta superior se encuentra una acogedora buhardilla con múltiples posibilidades de uso. La casa dispone de 3 habitaciones dobles y 2 baños completos, ofreciendo comodidad y amplitud para toda la familia.","https://es.wallapop.com/item/casa-adosada-en-venta-en-lhort-de-senabre-en-valencia-1270731812","https://cdn.wallapop.com/images/10420/l0/k6/__/c10420p1270731812/i6549883144.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Garaje céntrico","Garaje",18000.0,12,"Valencia","SOLIDINMUEBLES VENDE planta garaje completa, super céntrico en el Pla del Remei, Valencia\n" +
                "Ubicación perfecta, en pleno centro y con 5 plazas de parquin.\n" +
                "Una oportunidad, tanto para residentes como para inversores, de disponer de un garaje privado en una de las zonas más demandadas de la ciudad.\n" +
                "Se trata de una planta completa en un tercer sótano de un edificio de 2003, con acceso para vehículos mediante plataforma elevadora.\n" +
                "Cuenta con una superficie total de 76,38 m², con 5 referencias catastrales diferentes. El espacio es versátil, pudiendo ser utilizado como garaje para aparcar 5 coches o habilitar una parte como trastero y reducir el número de plazas de aparcamiento.\n" +
                "No dude en contactarnos para ampliar información o solicitar una visita.\n" +
                "\n" +
                "WE SPEAK ENGLISH\n" +
                "NOUS PARLONS FRANCAIS","https://es.wallapop.com/item/garaje-en-venta-en-el-pla-del-remei-en-valencia-1249903877","https://cdn.wallapop.com/images/10420/ko/5s/__/c10420p1249903877/i6418345679.jpg?pictureSize=W640"));

        anuncios.add(createEstate("id"+random.nextInt(100),"Piso en Chamberí","Piso",420000.0,90,"Madrid","A-House les ofrece esta ultima planta, lista PARA ENTRAR A VIVIR situada en Justicia.\n" +
                "\n" +
                "La propiedad está distribuida en cocina abierta, área de noche y baño.\n" +
                "\n" +
                "El inmueble dispone de sistema de climatización mediante bomba de frío/calor, armario empotrado, aire acondicionado y ventana PVC-climalit.\n" +
                "\n" +
                "La vivienda fue reformada recientemente en su totalidad, se encuentra en buen estado de conservación, LISTA PARA ENTRAR A VIVIR.\n" +
                "\n" +
                "Finca del año 1920 con ASCENSOR Y PORTERO.\n" +
                "\n" +
                "Las estaciones de metro de Madrid con parada en el barrio de Justicia son Banco de España (línea 2), Gran Vía (líneas 1 y 5), Bilbao (líneas 1 y 4), Tribunal (líneas 1 y 10), Alonso Martínez (líneas 4, 5 y 10), Colón (línea 4) y Chueca (línea 5). Además, aquí se encuentra la estación de cercanías de Recoletos, por la que pasan las líneas C-1, C-2, C-7, C-8 y C-10. Algunos de los autobuses que tienen parada en este barrio son: 1, 2, 3, 5 7, 9, 10, 14, 15, 20, 21, 27, 34, 37, 40, 45, 46, 51, 52, 53, 74, 146, 147, 149, 150, 001, 002, C03, N1, N2, N3, N4, N5, N6, N7, N8, N9, N10, N11, N12, N13, N14, N15, N16, N17, N18, N19, N20, N21, N22, N23, N24, N25, N26, Exprés Aeropuerto y M1.","https://es.wallapop.com/item/piso-en-venta-en-justicia-chueca-en-madrid-1271407590","https://cdn.wallapop.com/images/10420/l0/yo/__/c10420p1271407590/i6554557849.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Ático luminoso","Ático",580000.0,110,"Madrid","Ático abuhardillado con encanto en el centro de Madrid - Calle Vicente Ferrer, 52\n" +
                "\n" +
                "Exclusivo ático abuhardillado situado en un edificio histórico de 1900, en pleno corazón de Madrid, a escasos metros de la calle San Bernardo, una de las zonas más dinámicas y cotizadas del centro.\n" +
                "\n" +
                "La vivienda, ubicada en una cuarta planta sin ascensor, cuenta con 50 m² construidos y ha sido cuidadosamente actualizada hace aproximadamente 10 años, combinando el carácter original del edificio con un estilo funcional y actual.\n" +
                "\n" +
                "Dispone de un dormitorio, un baño completo, salón luminoso y cocina equipada, todo ello integrado en un espacio acogedor y con personalidad, donde la buhardilla aporta un valor diferencial único.\n" +
                "\n" +
                "El acceso por escaleras es cómodo y bien resuelto.","https://es.wallapop.com/item/atico-en-venta-en-universidad-malasana-en-madrid-1270762665","https://cdn.wallapop.com/images/10420/l0/ku/__/c10420p1270762665/i6550217693.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Casa independiente","Casa",650000.0,220,"Madrid","Grupo inmobiliario vende, en el corazón de Justicia, junto a Chueca y en una de las calles más cotizadas del barrio, Calle de Gravina, esta exclusiva vivienda en planta baja de con una espectacular terraza privada. Vivienda 70m2 de casa, más 40m2 de terraza aproximados\n" +
                "\n" +
                "La propiedad destaca por su acceso directo desde el salón a una magnífica terraza, concebida como una auténtica extensión de la vivienda, con agradable zona cubierta bajo pérgola y espacio descubierto ideal para disfrutar del exterior durante todo el año.\n" +
                "\n" +
                "La vivienda cuenta con una cómoda distribución: hall de entrada, amplio salón con salida a terraza, cocina independiente, dos dormitorios y dos baños. Además, dispone de un portal representativo y cuidado, acorde con el carácter señorial de la finca.","https://es.wallapop.com/item/piso-en-venta-en-justicia-chueca-en-madrid-1270726922","https://cdn.wallapop.com/images/10420/l0/k3/__/c10420p1270726922/i6549829371.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Garaje zona centro","Garaje",35000.0,14,"Madrid","Garaje en CHUECA-JUSTICIA, con 10 m², cerrado, interior. Plaza de garaje con una superficie de 10 m² en venta situada en Madrid. Se trata de una plaza de garaje con una superficie de 10 m², situada en la planta -1 del sótano de un edificio construido en 2008, de fácil acceso desde el exterior y buena maniobrabilidad en el interior. Buenas comunicaciones, próxima a estaciones de metro, con paradas de autobús y a través del acceso viario M-30 a unos minutos. La zona dispone de equipamiento variado, centro de salud, restaurantes, centro cultural, el Paseo del Prado, etc. Con nuestros servicios podrá encontrar el garaje que necesita.","https://es.wallapop.com/item/garaje-en-venta-en-justicia-chueca-en-madrid-1271996921","https://cdn.wallapop.com/images/10420/l1/bb/__/c10420p1271996921/i6558311800.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Piso familiar","Piso",310000.0,105,"Madrid","AMPLIA VIVIENDA EXTERIOR CON DOS TERRAZAS Y GRANDES POSIBILIDADES DE REFORMA EN IMPERIAL\n" +
                "\n" +
                "Si buscas espacio, luz y la oportunidad de diseñar una vivienda completamente a tu medida, esta propiedad reúne todo lo necesario para convertirse en un hogar excepcional. Situada en una tercera planta exterior con ascensor, en una de las zonas residenciales más demandadas y agradables de Madrid, ofrece 114 m2 con una distribución versátil y un enorme potencial de transformación.\n" +
                "\n" +
                "La vivienda cuenta actualmente con cuatro dormitorios, un baño completo, un aseo y una amplia cocina con office, además de dos terrazas que aportan luminosidad, amplitud y una conexión privilegiada con el exterior. La terraza principal se convierte en el espacio perfecto para disfrutar de desayunos al sol, comidas en familia o momentos de desconexión sin salir de casa. Sus dimensiones y distribución permiten adaptarla fácilmente a las necesidades actuales, creando amplias zonas de día, espacios de teletrabajo o una vivienda familiar moderna y funcional.\n" +
                "\n" +
                "Ubicada en el barrio de Imperial, uno de los enclaves con mejor calidad de vida dentro de la almendra central de Madrid, combina la tranquilidad de una zona residencial consolidada con la cercanía al centro histórico. A pocos minutos se encuentran Madrid Río, la Puerta de Toledo, el Palacio Real y amplias zonas verdes, deportivas y comerciales. Además, dispone de excelentes comunicaciones gracias a las estaciones de metro de Puerta del Ángel, Pirámides y Príncipe Pío, así como múltiples líneas de autobús y Cercanías.","https://es.wallapop.com/item/piso-en-venta-en-imperial-en-madrid-1271718768","https://cdn.wallapop.com/images/10420/l1/5c/__/c10420p1271718768/i6556505298.jpg?pictureSize=W640"));

        anuncios.add(createEstate("id"+random.nextInt(100),"Piso cerca de la playa","Piso",260000.0,88,"Málaga","Hay viviendas... y luego están las que te permiten vivir Málaga desde una de sus zonas más exclusivas.\n" +
                "\n" +
                "Huspy presenta esta propiedad en La Malagueta, a escasos pasos de la playa y del centro histórico de Málaga, una ubicación donde el estilo de vida mediterráneo, la conexión urbana y la rentabilidad se unen de forma natural.\n" +
                "\n" +
                "La vivienda destaca por su excelente distribución y por una atmósfera luminosa y acogedora, ideal tanto para disfrutar como residencia habitual como para quienes buscan una inversión en una de las zonas con mayor demanda de Málaga.\n" +
                "\n" +
                "El salón-comedor diáfano conecta con una cocina integrada, moderna y funcional, creando un espacio cómodo y práctico para el día a día.\n" +
                "\n" +
                "Además, dispone de un dormitorio independiente amplio y tranquilo, pensado para ofrecer privacidad y confort.","https://es.wallapop.com/item/piso-en-venta-en-la-malagueta-la-caleta-en-malaga-1270718879","https://cdn.wallapop.com/images/10420/l0/jw/__/c10420p1270718879/i6549741357.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Casa con piscina","Casa",430000.0,180,"Málaga","Magnífico piso construido en el 2023!\n" +
                "\n" +
                "La zona donde se encuentra esta propiedad está en plena expansión, por la construcción del nuevo hospital y por el METRO principalmente que tendrá una parada muy cerca de la casa. El acceso a la autovía es fácil y también puedes vivir sin coche por la cercanía al centro, por las tiendas y restaurantes que están por la zona y por la accesibilidad al transporte público.\n" +
                "\n" +
                "¡Descubre tu nuevo hogar en la encantadora calle Bailén! Este espectacular piso de tres dormitorios ofrece una combinación perfecta de modernidad y confort. Con 95 m² construidos, cuenta con un amplio salón que se integra a una cocina completamente amueblada y equipada con todos los electrodomésticos necesarios, incluyendo lavadora, lavavajillas y horno.\n" +
                "\n" +
                "Uno de los dormitorios tiene un gran tamaño y los otros dos dormitorios tienen un tamaño bueno también. Además, el trastero es un gran añadido para mantener todo en orden. La azotea es un verdadero oasis, con piscina y vistas espectaculares que te permitirán disfrutar del clima y la belleza de la zona.\n" +
                "\n" +
                "Las ventanas son de climalit abatibles, tiene puerta de seguridad, el suelo es cerámico y los muebles de la cocina son de gran calidad y la encimera de silestone.\n" +
                "\n" +
                "La climatización mediante bomba de frío/calor asegura un ambiente agradable durante todo el año. Se vende completamente amueblado, lo que lo convierte en una opción ideal tanto para vivir como para invertir. ¡No dejes pasar esta oportunidad única de adquirir un hogar en una de las zonas más vibrantes de la ciudad!","https://es.wallapop.com/item/piso-en-venta-en-gamarra-la-trinidad-en-malaga-1270758024","https://cdn.wallapop.com/images/10420/l0/kr/__/c10420p1270758024/i6550167617.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Ático vistas al mar","Ático",520000.0,100,"Málaga","EXCLUSIVA PROMOCIÓN GS LIMONAR HILLS.\n" +
                "\n" +
                "En la Calle Monte Miramar 56 se alza GS Limonar Hills, una prestigiosa promoción de obra nueva situada en el corazón de El Limonar, uno de los enclaves más exclusivos y con mayor encanto de Málaga.\n" +
                "\n" +
                "Su ubicación elevada permite disfrutar de vistas panorámicas al mar y a la ciudad, en un entorno tranquilo y con una calidad de vida excepcional.\n" +
                "\n" +
                "El proyecto ofrece viviendas de 1 a 4 dormitorios con piscinas, solárium, garaje y trasteros, diseñadas bajo un enfoque de excelencia en cada detalle.\n" +
                "\n" +
                "Espacios donde la luz natural es protagonista y la amplitud se percibe en cada rincón, con arquitectura de vanguardia, materiales cuidadosamente seleccionados y un diseño que eleva lo cotidiano.\n" +
                "\n" +
                "Un residencial concebido para crecer, para desconectar, para quedarse.\n" +
                "\n" +
                "Porque elevar su vida es elegir un hogar a su altura:\n" +
                "GS Limonar Hills.\n" +
                "\n" +
                "Las unidades en esta localización son muy limitadas y el interés es muy alto. En Stela Mare Luxury Real Estate gestionamos la venta exclusiva de esta promoción y queremos ayudarte a adelantarte.\n" +
                "\n" +
                "Déjanos tus datos ahora para recibir de forma prioritaria los planos, la memoria de calidades completa y la disponibilidad actualizada antes de que se agoten las mejores unidades.","https://es.wallapop.com/item/atico-en-venta-en-el-mayorazgo-el-limonar-en-malaga-1270738530","https://cdn.wallapop.com/images/10420/l0/kc/__/c10420p1270738530/i6549958056.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Garaje cubierto","Garaje",22000.0,13,"Málaga","Plaza de Aparcamiento en el centro de Málaga\n" +
                "\n" +
                "¡Oportunidad única en Nuevo Perchel! Se vende una amplia plaza de garaje, ideal para quienes buscan comodidad y seguridad en su día a día. Ubicada en un moderno residencial de nueva construcción, esta plaza es perfecta para coches grandes, ofreciendo el espacio necesario para maniobrar sin preocupaciones.\n" +
                "\n" +
                "La plaza cuenta con acceso cubierto y una puerta automática que garantiza la máxima comodidad al entrar y salir. Además, el edificio dispone de ascensor, facilitando el acceso a los residentes. No dejes pasar la oportunidad de adquirir este garaje en una de las zonas más cotizadas de Málaga. ¡Contáctanos y asegura tu plaza hoy mismo!","https://es.wallapop.com/item/garaje-en-venta-en-perchel-norte-la-trinidad-en-malaga-1214020672","https://cdn.wallapop.com/images/10420/k2/so/__/c10420p1214020672/i6185037130.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Casa rural","Campo",175000.0,160,"Málaga","Casa de campo con piscina privada y amplios espacios exteriores en Puerto de la Torre, Málaga, una ubicación privilegiada que combina la tranquilidad del entorno natural con la cercanía a la ciudad. \n" +
                "\n" +
                "Esta magnífica propiedad destaca por ofrecer privacidad, amplitud y comodidad, convirtiéndose en una opción ideal para familias que desean disfrutar de un estilo de vida relajado sin renunciar a los servicios urbanos.\n" +
                "\n" +
                "Características principales:\n" +
                "\n" +
                "Parcela de 750 m²\n" +
                "Vivienda de 200 m² útiles\n" +
                "Suelo urbano y rústico\n" +
                "Orientación sur\n" +
                "Excelente privacidad\n" +
                "Lista para entrar a vivir\n","https://es.wallapop.com/item/casa-rural-en-venta-en-puerto-de-la-torre-atabal-en-malaga-1271718495","https://cdn.wallapop.com/images/10420/l1/5c/__/c10420p1271718495/i6556502056.jpg?pictureSize=W640"));

        anuncios.add(createEstate("id"+random.nextInt(100),"Piso céntrico Barcelona","Piso",390000.0,82,"Barcelona","Piso En Calle Roig reformado y céntrico. Inmueble de 40 metros, que constas de 2 dormitorios los cuales todos tienen ventilación al exterior, un baño, cocina americana totalmente equipada, y aire acondicionado  frío-calor.\n" +
                "Cuarta planta real en finca con ITE pasada y Certificado de Aptitud.\n" +
                "A pocos metros de Ronda Sant Antoni, el mercado de la Boquería, MACBA, de las Ramblas, así como buena comunicación con estaciones de metro (Liceu y Sant Antoni).\n" +
                "¡Oportunidad única en el centro histórico de Barcelona! Ideal para primera vivienda y excelente inversión en zona con fuerte demanda de alquiler.  \n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "El precio de venta del inmueble aquí expuesto no incluye impuestos ni gastos que grava la compraventa (ITP o IVA, gastos notariales o registrales), tampoco los honorarios de agencia por intermediación inmobiliaria, ni gestión hipotecaria.\n" +
                "\n" +
                "ICAT 3376.","https://es.wallapop.com/item/piso-en-venta-en-el-raval-en-barcelona-1270951477","https://cdn.wallapop.com/images/10420/l0/ow/__/c10420p1270951477/i6551601837.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Ático Eixample","Ático",690000.0,115,"Barcelona","Luminoso ático a reformar en finca histórica con una ubicación inmejorable en el centro de Barcelona.\n" +
                "\n" +
                "Vive el encanto del Eixample desde tu propio ático con terraza privada.\n" +
                "\n" +
                "La primera foto de la terraza es un render.\n" +
                "\n" +
                "Oportunidad única de adquirir un encantador y soleado ático en una de las zonas más prestigiosas de Barcelona: el Quadrat d'Or, en pleno corazón del Eixample. Ubicado en la última planta (quinta real) de una finca clásica completamente rehabilitada en 2011, esta propiedad ofrece un enorme potencial tanto como vivienda habitual como inversión de alto valor.\n" +
                "\n" +
                "Con una distribución práctica y funcional, la vivienda dispone de una amplia zona de estar y comedor de concepto abierto, con salida a un balcón que da a la calle principal. Gracias a su orientación sur y al diseño en chaflán del edificio, el piso disfruta de una excelente entrada de luz natural durante todo el día. La cocina es independiente y se encuentra junto al comedor, contando además con un espacio de lavadero.\n" +
                "\n" +
                "El ático cuenta con dos dormitorios, uno de ellos en suite, y dos baños (uno también en suite). Uno de sus grandes atractivos es el solárium privado de 38 m², ideal para disfrutar del aire libre, relajarse o recibir invitados bajo el sol mediterráneo. Uno de sus grandes atractivos es el solárium privado de 38 m², ideal para disfrutar del aire libre, crear una zona chill-out o jardín urbano.\n" +
                "\n" +
                "Entre sus características adicionales se incluyen carpintería exterior con doble acristalamiento, suelos de parqué y sistema de calefacción y aire acondicionado por conductos. Aunque requiere reforma, el inmueble ofrece una base sólida y versátil para crear una vivienda a medida en una ubicación privilegiada.\n" +
                "\n" +
                "Vivir en el Quadrat d'Or significa estar rodeado de joyas arquitectónicas, boutiques exclusivas, restaurantes de renombre, galerías de arte y mercados locales, todo a pocos pasos. Esta zona combina a la perfección historia, cultura y vida cosmopolita. Además, la propiedad goza de una exce","https://es.wallapop.com/item/atico-en-venta-en-l-antiga-esquerra-de-l-eixample-en-barcelona-1270722261","https://cdn.wallapop.com/images/10420/l0/jz/__/c10420p1270722261/i6557275544.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Casa en Sant Cugat","Casa",780000.0,250,"Barcelona","CENTURY21 presenta en exclusiva.. .\n" +
                "\n" +
                "Casa independiente de 88 m², 73 m2 útiles y 376 m2 de terreno, orientada al sur con 3 terrazas en Les Planes\n" +
                "\n" +
                "Se vende casa independiente de 73 m² construidos con orientación sur, ubicada en una zona residencial muy tranquila en Les Planes. La propiedad ofrece un lugar ideal donde vivir en plena naturaleza, destacando por sus vistas despejadas a la montaña y con conectividad, situándose a 15 minutos a pie (o 5 minutos en coche) de la estación de Ferrocarrils de la Generalitat (FGC) y a tan solo 10 min de Barcelona por los túneles de Vallvidrera.\n" +
                "\n" +
                "Gracias a su orientación sur, cuenta con un excelente aprovechamiento del sol. Todas las estancias son completamente exteriores y muy luminosas. Además, la propiedad dispone de muchas posibilidades de adaptación y aprovechamiento debido a la amplitud de sus espacios exteriores y sus diversas terrazas.\n" +
                "\n" +
                "La casa se distribuye de la siguiente forma:\n" +
                "\n" +
                "Zona de día: Salón-comedor con cocina abierta integrada.\n" +
                "\n" +
                "Zona de noche: Dos habitaciones. Una de ellas dispone de un altillo acondicionado y utilizado actualmente como despacho o zona de estudio.","https://es.wallapop.com/item/chalet-en-venta-en-la-floresta-les-planes-en-sant-cugat-del-valles-1270720285","https://cdn.wallapop.com/images/10420/l0/jy/__/c10420p1270720285/i6549757370.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Garaje doble","Garaje",42000.0,20,"Barcelona","Consejo de Ciento-Paseo San Juan.\n" +
                "¡Descubre la oportunidad perfecta para asegurar tu vehículo en una ubicación inmejorable! Este garaje en venta ofrece una amplia plaza de parking doble en línea. Con unas medidas de 2,17m x 8,25m, tendrás espacio suficiente para estacionar cómodamente y sin preocupaciones. La comodidad se eleva con el acceso mediante una app, lo que garantiza que puedas entrar y salir con facilidad y seguridad.\n" +
                "\n" +
                "Ubicado en una zona estratégica, este garaje no solo es un lugar para aparcar, sino también una inversión inteligente. No dejes pasar la oportunidad de disfrutar de esta solución práctica y moderna para tus necesidades de estacionamiento. ¡Contáctanos ahora y asegura tu plaza!","https://es.wallapop.com/item/garaje-en-venta-en-la-dreta-de-l-eixample-en-barcelona-1229767640","https://cdn.wallapop.com/images/10420/kc/66/__/c10420p1229767640/i6462990195.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Piso reformado","Piso",345000.0,90,"Barcelona","***Piso Reformado en el Corazón del Gótico - ¡Una Joya Histórica! ***\n" +
                "\n" +
                "Descubre este encantador piso reformado en una finca histórica del 1800, ubicado en pleno corazón del barrio Gótico.\n" +
                "Con 70 m² construidos, esta propiedad en la tercera planta real ofrece un espacio único y acogedor, ideal para disfrutar de la vida urbana.\n" +
                "\n" +
                "El piso cuenta con dos acogedoras habitaciones; una de ellas con balcón que regala vistas al vibrante barrio.\n" +
                "La cocina americana está equipada con electrodomésticos de calidad, perfecta para los amantes de la gastronomía. Además, el baño completo presenta acabados de lujo que aportan un toque de elegancia y glamour.\n" +
                "\n" +
                "La ubicación es inmejorable, rodeada de historia y cultura, lo que convierte a este piso en una excelente opción tanto para vivir como para invertir.\n" +
                "No dejes pasar la oportunidad de vivir en un lugar donde cada rincón cuenta una historia.\n" +
                "¡Ven a visitarlo y enamórate de su encanto!","https://es.wallapop.com/item/piso-en-venta-en-el-gotic-en-barcelona-1272251747","https://cdn.wallapop.com/images/10420/l1/gr/__/c10420p1272251747/i6559642803.jpg?pictureSize=W640"));

        anuncios.add(createEstate("id"+random.nextInt(100),"Piso económico","Piso",95000.0,70,"Murcia","\n" +
                "Redpiso vende piso de 73m² en 2ª planta SIN ascensor, muy luminoso y con orientación Sur. Distribuido en 3 dormitorios, salón independiente, cocina con lavadero y despensa, 1 baño y trastero. Vivienda cómoda y bien distribuida, lista para entrar a vivir. Ideal para familias o como inversión.\n" +
                "Ubicado en una zona consolidada y muy práctica para el día a día, con todos los servicios necesarios a pocos minutos: supermercados, farmacias, centros de salud, transporte público, comercios y zonas de ocio. Además, cuenta con colegios, parques y espacios verdes cercanos, lo que la convierte en una excelente opción.\n" +
                "\n" +
                "Si necesita financiación, contamos con un departamento financiero interno que le ayudará con su hipoteca. Financiación 100% según su perfil económico. Llámenos sin compromiso y les informaremos.\n" +
                "El precio no incluye el Impuesto de Transmisiones Patrimoniales (Max. 7.75% sobre el precio de venta o del valor del inmueble que marque la Comunidad de Murcia), ni el 3% (con un mínimo de 5.000€) más IVA (21%) sobre el precio final del inmueble equivalente a los honorarios del comprador por la intermediación inmobiliaria (viviendas inferiores a 200.000€ el 4%+IVA), ni los gastos notariales y/o registrales (según el caso).","https://es.wallapop.com/item/piso-en-venta-en-san-andres-san-anton-en-murcia-1270726801","https://cdn.wallapop.com/images/10420/l0/k3/__/c10420p1270726801/i6549828035.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Casa adosada Murcia","Casa",165000.0,135,"Murcia","La propiedad no dispone de la posesión del inmueble. No se puede visitar. No apta para compradores que requieran financiación hipotecaria. El comprador será responsable de los trámites y gastos relacionados con la desocupación del inmueble. La información proporcionada a la distribución y estructura puede no ajustarse a la realidad, su verificación no ha sido posible. La distribución y fotografías del interior y las características del activo pueden no ajustarse al estado actual.\n" +
                "\n" +
                "El Inmueble se transmitirá (i) como cuerpo cierto y a tanto alzado (ii) como un todo, inseparable (iii) al corriente de gastos e impuestos que por Ley corresponda al Vendedor. El Adquirente asumirá (i) la situación física (impedimento intervenciones para tasación oficial (Orden ECO/805/2003) registral, jurídica, catastral, urbanística, así como el estado de conservación y limpieza (ii) las discrepancias entre la realidad física y la realidad registral y catastral o en la cabida del Inmueble (iv) la obtención del certificado de eficiencia energética conforme sea permitido por la normativa oportuna.\n" +
                "\n" +
                "De estar judicializado el adquirente, tendrá la oportunidad de subrogarse procesalmente, no pudiendo reclamar importe alguno a la Propiedad como consecuencia de ello, salvo los honorarios de abogados y procuradores que hasta la fecha de la transmisión se hubiesen devengado que, en cualquier caso, serán por cuenta de éste. En el caso de estar arrendado, la Propiedad no se responsabiliza de importes de fianzas o garantías que se hubieran constituido en el contrato, exonerando a la Propiedad de la entrega de dichas fianzas y/o garantías. El precio de venta del Inmueble se ha determinado en base a las anteriores circunstancias, que han supuesto un menor valor respecto a otras referencias del mercado y que deberán ser expresamente aceptadas por el adquirente en la formalización de la transmisión del Inmueble. Se recomienda que el comprador obtenga asesoramiento profesional y legal antes de la compra.","https://es.wallapop.com/item/casa-adosada-en-venta-en-san-andres-san-anton-en-murcia-1270741028","https://cdn.wallapop.com/images/10420/l0/ke/__/c10420p1270741028/i6549986221.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Ático céntrico Murcia","Ático",220000.0,92,"Murcia","\n" +
                "Venta Ático muy céntrico, junto a La Plaza Romea, 130 m2. + terraza, Distribuido en 2 plantas, baja: salón comedor, cocina amueblada con office, recibidor muy amplio y luminoso, 2 dormitorios con armarios empotrados, 2 baños completos uno de ellos incorporado al principal, planta alta: dormitorio/salón/estudio, 1 baño y terraza de 20 m2. con trastero/lavadero, todo en perfecto estado, para entrar a vivir. Muy buenas calidades, pintura lisa, aire acondicionado centralizado con bomba de frío/ calor, carpintería exterior en madera e interior en nogal, suelo de tarima. Plaza de garaje en propiedad incluida en el precio.\n" +
                "\n" +
                "NOTA INFORMATIVA LEGAL:\n" +
                "En cumplimiento de la normativa vigente, se informa que el precio de venta del inmueble anunciado, no incluye los gastos e impuestos derivados de la compraventa, tales como:\n" +
                "- Impuesto sobre Transmisiones Patrimoniales (ITP)\n" +
                "- Gastos de notaría.\n" +
                "-Inscripción en el Registro de la Propiedad.\n" +
                "- Honorarios de intermediación inmobiliaria.","https://es.wallapop.com/item/atico-en-venta-en-centro-en-murcia-1270712761","https://cdn.wallapop.com/images/10420/l0/js/__/c10420p1270712761/i6554970800.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Campo con terreno","Campo",210000.0,200,"Murcia","Se vende finca de campo con 13000m de terreno,dos viviendas amuebladas listas para entrar a vivir, 200 metros de naves/salones y una piscina amplia.\n" +
                "Para más información llame al 639676401","https://es.wallapop.com/item/terreno-en-venta-442740865","https://cdn.wallapop.com/images/10420/7b/lh/__/c10420p442740865/i1160296159.jpg?pictureSize=W640"));
        anuncios.add(createEstate("id"+random.nextInt(100),"Garaje centro Murcia","Garaje",14000.0,11,"Murcia","PLAZA DE GARAJE EN VENTA EN Bº DEL CARMEN\n" +
                "\n" +
                "Situada en una de las zonas con mayor demanda y tráfico de Murcia, junto a Avenida Floridablanca, perfecta para residentes de la zona o trabajadores que necesitan un acceso rápido y directo al centro sin perder tiempo buscando aparcamiento en superficie, le ofrecemos esta plaza de garaje para coche pequeño ó mediano, ubicada en primera planta sótano con montacargas.\n" +
                "\n" +
                "Solicite más información.\n" +
                "\n" +
                "*VISITE NUESTRA WEB Pisocasion. es\n" +
                "\n" +
                "**El precio no incluye gastos derivados de la compra-venta (gastos notariales, registrales, impuestos. ) ni los honorarios inmobiliarios, que serán de 1.500. -€ + IVA.","https://es.wallapop.com/item/garaje-en-venta-en-el-carmen-en-murcia-1271719853","https://cdn.wallapop.com/images/10420/l1/5d/__/c10420p1271719853/i6556516076.jpg?pictureSize=W640"));

        System.out.println("Anuncios generados: " + anuncios.size());
    }

    private AnuncioMotoDto createMotor(String id,String title,String brand,
            String model,Double price,Integer km,Boolean a2,String location,
            String descripcion,String urlOrigen, String urlImagen) {

        AnuncioMotoDto ad = new AnuncioMotoDto();

        ad.setIdAnuncio(id);
        ad.setCategoria("Motor");
        ad.setTitulo(title);
        ad.setMarca(brand);
        ad.setModelo(model);
        ad.setPrecioValor(price);
        ad.setKilometros(km);
        ad.setEsParaA2(a2);
        ad.setUbicacion(location);
        ad.setEstado("Usado");
        ad.setDescripcion(descripcion);
        ad.setUrlOrigen(urlOrigen);
        ad.setUrlImagen(urlImagen);
        return ad;
    }

    private AnuncioInmobiliarioDto createEstate(
            String id,String title,String type,
            Double price,Integer m2,String location,
            String descripcion,String urlOrigen, String urlImagen
    ) {

        AnuncioInmobiliarioDto ad = new AnuncioInmobiliarioDto();

        ad.setIdAnuncio(id);
        ad.setCategoria("Inmobiliario");
        ad.setTitulo(title);
        ad.setTipoPropiedad(type);
        ad.setPrecioValor(price);
        ad.setMetrosCuadrados(m2);
        ad.setUbicacion(location);
        ad.setEstado("Usado");
        ad.setDescripcion(descripcion);
        ad.setUrlOrigen(urlOrigen);
        ad.setUrlImagen(urlImagen);

        return ad;
    }

    @Override
    public List<AnuncioDto> buscarTodo() {
        return anuncios;
    }
}
