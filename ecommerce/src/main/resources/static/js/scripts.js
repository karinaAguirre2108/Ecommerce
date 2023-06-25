/*!
    * Start Bootstrap - SB Admin v7.0.3 (https://startbootstrap.com/template/sb-admin)
    * Copyright 2013-2021 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
    */
    // 
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

});


//***************************************************************
// previsualizacion de imagenes - registrar  producto

$(document).ready(function() {
  // Obtener el campo de entrada de archivos
  var fileInput = $('input[type="file"][name="imagenes"]');

  // Escuchar el evento de cambio del campo de entrada de archivos
  fileInput.change(function() {
    var previewContainer = $('#image-preview-container');
    previewContainer.empty(); // Limpiar las vistas previas anteriores

    // Obtener los archivos seleccionados
    var files = $(this)[0].files;

    // Recorrer los archivos y generar las vistas previas
    for (var i = 0; i < files.length; i++) {
      var file = files[i];
      var reader = new FileReader();

      // Leer el archivo como una URL de datos
      reader.readAsDataURL(file);

      // Escuchar el evento de carga del archivo
      reader.onload = function(event) {
        var imageSource = event.target.result;
        var imageElement = $('<img class="img-thumbnail">').attr('src', imageSource);
        previewContainer.append(imageElement); // Agregar la vista previa al contenedor
      };
    }
  });
});
 
//***************************************************************
// previsualizacion de nuevas imagenes - editar  producto

$(document).ready(function() {
  // Obtener el campo de entrada de archivos
  var fileInput = $('input[type="file"][name="nuevasImagenes"]');

  // Escuchar el evento de cambio del campo de entrada de archivos
  fileInput.change(function() {
    var previewContainer = $('#image-preview-container');
    previewContainer.empty(); // Limpiar las vistas previas anteriores

    // Obtener los archivos seleccionados
    var files = $(this)[0].files;

    // Recorrer los archivos y generar las vistas previas
    for (var i = 0; i < files.length; i++) {
      var file = files[i];
      var reader = new FileReader();

      // Leer el archivo como una URL de datos
      reader.readAsDataURL(file);

      // Escuchar el evento de carga del archivo
      reader.onload = function(event) {
        var imageSource = event.target.result;
        var imageElement = $('<img class="img-thumbnail" >').attr('src', imageSource);
        previewContainer.append(imageElement); // Agregar la vista previa al contenedor
      };
    }
  });
});

