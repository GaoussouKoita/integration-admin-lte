$(function () {
 //Initialize Select2 Elements
    $('.select2bs4').select2({
      theme: 'bootstrap4'
    });
  })


//input file
$(function () {
  bsCustomFileInput.init();
});

//Toast
var Toast = Swal.mixin({
      toast: true,
      position: 'top-end',
      showConfirmButton: false,
      timer: 3000
    });

$('.swalDefaultError').click(function() {
      Toast.fire({
        icon: 'error',
        title: 'Utilisateur supprime.'
      })
    });

