# -*- coding: utf-8 -*-
import redis

r = redis.StrictRedis(db=15)

r.set("notas:usuario:delossantos:passwd", "delo")
r.set("notas:usuario:alcon:passwd", "alco")
r.set("notas:usuario:jerbi:passwd","jerb")

r.rpush("notas:nota:dws","alcon-08","jerbi-10","delossantos-10")
r.rpush("notas:nota:daw","alcon-09","jerbi-06","delossantos-09")
r.rpush("notas:nota:dwc","alcon-07","jerbi-10","delossantos-08")

r.rpush("notas:usuario:delossantos:notas", "dws10","daw09","dwc08")
r.rpush("notas:usuario:alcon:notas", "dws08","daw09","dwc07")
r.rpush("notas:usuario:jerbi:notas", "dws10","daw06","dwc10")


