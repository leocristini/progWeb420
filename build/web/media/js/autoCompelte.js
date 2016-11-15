$(document).ready(function() {
               $("#search_bar").autocomplete({
                    width: 300,
                    max: 10,
                    delay: 100,
                    minLength: 1,
                    autoFocus: true,
                    cacheLength: 1,
                    scroll: true,
                    highlight: false,
                    source: function(request,response){
                        $.ajax({
                            url: "/search_autocomplete",
                            dataType: "jsonp",
                            data:{ 
                                q: request.term
                            }, 
                            success: function(data){
                                response(data);
                            }
                        });
                   }
                   
               });
           }) ;