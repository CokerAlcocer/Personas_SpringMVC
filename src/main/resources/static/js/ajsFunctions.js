
    function listarPersona (idPersona) {
        const contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
        $.ajax({
            type: 'GET',
            url: contextPath + '/listar/' + idPersona,
        }).done(function (response){
        })
    };



