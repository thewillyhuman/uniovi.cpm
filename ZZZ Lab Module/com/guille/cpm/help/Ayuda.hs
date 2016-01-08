<?xml version='1.0' encoding='ISO-8859-1' ?>
<!DOCTYPE helpset
  PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp HelpSet Version 1.0//EN"
         "http://java.sun.com/products/javahelp/helpset_1_0.dtd">


<helpset version="1.0">
  <!-- title -->
  <title>Cruise Booking Platform/Plataforma Reservas de Cruceros</title>

  <!-- maps -->
  <maps>
     <homeID>introduction</homeID>
     <mapref location="Map.jhm"/>
  </maps>

  <!-- views -->
  <view>
    <name>Table of contents/Tabla de contenidos</name>
    <label>Table of contents/Tabla de contenidos</label>
    <type>javax.help.TOCView</type>
    <data>TOC.xml</data>
  </view>

  <view>
    <name>Index/Indice</name>
    <label>Index/Indice</label>
    <type>javax.help.IndexView</type>
    <data>Indice.xml</data>
  </view>

  <view>
    <name>Search/Busqueda</name>
    <label>Search/Busqueda</label>
    <type>javax.help.SearchView</type>
    <data engine="com.sun.java.help.search.DefaultSearchEngine">
      JavaHelpSearch
    </data>
  </view>

</helpset>
