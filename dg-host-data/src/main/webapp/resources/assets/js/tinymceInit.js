tinymce.init({
    selector: ".tinymce",
//    height : 300,
    theme: "modern",
    plugins: [
        "advlist autolink lists link image charmap print preview hr anchor pagebreak",
        "searchreplace wordcount visualblocks visualchars code fullscreen",
        "insertdatetime media nonbreaking save table contextmenu directionality",
        "emoticons widget paste textcolor colorpicker textpattern moxiemanager"
    ],
    menu : { // this is the complete default configuration
        edit   : {title : 'Edit'  , items : 'undo redo | cut copy paste pastetext | selectall'},
        insert : {title : 'Insert', items : 'link media | template hr'},
        view   : {title : 'View'  , items : 'visualaid'},
        format : {title : 'Format', items : 'bold italic underline strikethrough superscript subscript | formats | removeformat'},
        table  : {title : 'Table' , items : 'inserttable tableprops deletetable | cell row column'},
        tools  : {title : 'Tools' , items : 'spellchecker code'}
    },
    content_css: '//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.2.0/css/bootstrap.min.css',
    toolbar1: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | print preview media",
    image_advtab: true,
    extended_valid_elements: '*[*|ng-view], div[*|ng-view]',
    valid_elements: '*[*|ng-view], div[*|ng-view]',
    external_plugins: {
        "moxiemanager": "/assets/admin/js/moxiemanager/plugin.min.js"
    },
    widgets: "/admin/widgets/list"
});