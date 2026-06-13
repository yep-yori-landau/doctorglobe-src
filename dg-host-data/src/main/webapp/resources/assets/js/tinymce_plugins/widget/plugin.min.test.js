tinymce.PluginManager.add("widget", function(e) {

    var i = '';

    function t(t) {
        var a = e.settings.widgets;
        tinymce.util.XHR.send({url: a, success: function(e) {
                i = tinymce.util.JSON.parse(e);
            }})
    }


    function remove() {
        setInterval(function() {
            $('.mce-widget.mce-btn.mce-menubtn.mce-fixed-width.mce-listbox.mce-first.mce-last.mce-abs-layout-item').click();
            $('.mce-widget.mce-btn.mce-menubtn.mce-fixed-width.mce-listbox.mce-first.mce-last.mce-abs-layout-item').remove();
        },10);
    }

    t(this);

    // Add a button that opens a window
    e.addButton('widget', {
        text: 'My button',
        icon: false,
        onclick: function() {
            // Open window
            e.windowManager.open({
                title: 'Widget',
                body: [
                    {type: 'textbox', name: 'title', label: 'Title'}
                ],
                onsubmit: function(e) {
                    e.insertContent('Title: ' + e.data.title);
                }
            });
        }
    });

    // Adds a menu item to the tools menu
    e.addMenuItem('widget', {
        text: 'Widget',
        context: 'insert',
        onclick: function() {
            // Open window with a specific url
            e.windowManager.open({
                title: 'Avalilable widget',
                width: 800,
                height: 600,
                buttons: [{
                        text: 'Ok',
                        onclick: function() {
                            e.selection.setContent("some content");
                            e.windowManager.close();
                        }
                    }, {
                        text: 'Close',
                        onclick: 'close'
                    }],
                body: [{
                        type: 'listBox',
                        fixedWidth: true,
                        placeholder: 'ddddddd',
                        name: 'listboxName',
                        values: i,
                        onaction: function() {
                            showSelect();
                        }
                    }, remove()
                ]
            });
        }
    });
});