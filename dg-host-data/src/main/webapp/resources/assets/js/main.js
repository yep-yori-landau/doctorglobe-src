// Browser detect
var matched, browser;

jQuery.uaMatch = function (ua) {
    ua = ua.toLowerCase();

    var match = /(chrome)[ \/]([\w.]+)/.exec(ua) ||
            /(webkit)[ \/]([\w.]+)/.exec(ua) ||
            /(opera)(?:.*version|)[ \/]([\w.]+)/.exec(ua) ||
            /(msie) ([\w.]+)/.exec(ua) ||
            ua.indexOf("compatible") < 0 && /(mozilla)(?:.*? rv:([\w.]+)|)/.exec(ua) ||
            [];

    return {
        browser: match[ 1 ] || "",
        version: match[ 2 ] || "0"
    };
};

matched = jQuery.uaMatch(navigator.userAgent);
browser = {};

if (matched.browser) {
    browser[ matched.browser ] = true;
    browser.version = matched.version;
}

// Chrome is Webkit, but Webkit is also Safari.
if (browser.chrome) {
    browser.webkit = true;
} else if (browser.webkit) {
    browser.safari = true;
}
jQuery.browser = browser;


$(function () {

    $('.resources-actions').change(function (e) {
        $.ajax({
            url: $(".form-horizontal").attr("action") + '/' + $(this).find(":selected").val(),
            dataType: 'html',
            type: "get",
            success: function (data) {
                $('.action-content').html(data);
            },
            error: function (data) {

            },
            complete: function () {

            }
        });
    });

    $('.acl-resources').change(function (e) {
        $.ajax({
            url: $(".form-horizontal").attr("action") + '/0/' + $(this).find(":selected").val() + '/0',
            dataType: 'html',
            type: "get",
            success: function (data) {
                $('.acl-actions').html(data);
            },
            error: function (data) {

            },
            complete: function () {

            }
        });
    });

    // Referral page preview use in view/referral/pagelist.phtml
    $('#page_list a#preview').click(function (e) {
        e.preventDefault();
        window.open($(this).attr('href'), 'window name', 'window settings');
    });

    $('.selectpicker').select2();

    // Referral page change display status
    $('.referralPageStatus').on('click', function () {
        ajaxCall("id=" + $(this).attr('data-id') + "&status=" + +$(this).prop('checked'), '/admin/referrals/changedisplaystatus/');
    });

    // Call back change display status
    $('.callBackStatus').on('click', function () {
        ajaxCall("id=" + $(this).attr('data-id') + "&status=" + +$(this).prop('checked'), '/admin/callback/changestatus/');
    });

    // Referral page change default display status
    $(".globalReferralPageStatus").on('click', function () {
        ajaxCall("option=" + $(this).attr('name') + "&value=" + $(this).attr('value'), $(this).attr('data-url'));
    });
    // Call back change default display status
    $(".globalCallBackStatus").on('click', function () {
        ajaxCall("option=" + $(this).attr('name') + "&value=" + $(this).attr('value'), $(this).attr('data-url'));
    });

    $('.saveAllChatCategories').click(function (e) {
        e.preventDefault();
        ajaxCall($('.chatIndexCategory').serialize(), $(this).attr('data-url'));
    });

    $('.saveChatCategory').click(function (e) {
        e.preventDefault();
        var selector = $("[name='category[" + $(this).attr('data-id') + "]']");
        var page_type = "&page_type=" + $(this).attr('data-type');
        ajaxCall("category[" + $(this).attr('data-id') + "]=" + selector.find(":selected").val() + page_type, $(this).attr('data-url'));
    });

    $('.deleteChatCategory').click(function (e) {
        e.preventDefault();
        var select = $("[name='category[" + $(this).attr('data-id') + "]']");
        var page_type = "&page_type=" + $(this).attr('data-type');
        ajaxCall("page=" + $(this).attr('data-id') + page_type, '/admin/chat/deletecategory');
        select.prop('selectedIndex', 0);
    });

    // card page 

    // show create form
    $('.addNewCard').click(function (e) {
        e.preventDefault();
        $('form#card').show(300);
        $(this).hide();
    });

    $('.creditCard .card input:text').keyup(function () {
        $(this).val($(this).val().trim().replace(/[^0-9.]/g, ''));
    });

    $('.creditCard .card input[type="text"]').change(function () {
        var selectOption = $(this);
        var parentTr = $(this).parent().parent();
        $('input:radio[name="amount[' + parentTr.attr('id') + ']"]').attr('checked', false);
        parentTr.children('td').each(function () {
            if (($(this).children('input:text').length > 0) && ($(this).children('input:text').attr('name') != selectOption.attr('name'))) {
                $(this).children('input:text').val('');
            }
        })
    })

    $('.creditCard input:radio').change(function () {
        if ($(this).is(':checked')) {
            $(this).parent().parent().children('td').each(function () {
                if ($(this).children('input:text').length > 0) {
                    $(this).children('input:text').val('');
                }
            })
            // append goes here
        }
    });

    $('.creditCard .saveCard').click(function (e) {
        e.preventDefault();
        var amount = 'free';
        var chargeValue = 0;
        if ($('input[name="procent[' + $(this).attr('data-id') + ']"]').val()) {
            amount = 'procent';
            chargeValue = $('input[name="procent[' + $(this).attr('data-id') + ']"]').val();
        } else if ($('input[name="pound[' + $(this).attr('data-id') + ']"]').val()) {
            amount = 'pound';
            chargeValue = $('input[name="pound[' + $(this).attr('data-id') + ']"]').val();
        }
        var data = new Object();
        data = {amount: amount, status: $('input[name="status[' + $(this).attr('data-id') + ']"]').val(), chargeValue: chargeValue};
        ajaxCall(data, $(this).attr('href'));
    });

    $('.creditCard .deleteCard').click(function (e) {
        e.preventDefault();
        var url = $(this).attr('href');
        BootstrapDialog.show({
            type: BootstrapDialog.TYPE_DANGER,
            title: 'Delete',
            message: 'Are you sure you want to delete this card',
            buttons: [{
                    label: 'Yes',
                    action: function (dialog) {
                        ajaxCall(null, url);
                        dialog.close();
                    }
                }, {
                    label: 'No',
                    action: function (dialog) {
                        dialog.close();
                    }
                }]
        });

    });

    // end card page

    //start supplier page
    $('.addNewSupplier').click(function (e) {
        e.preventDefault();
        $('form#supplier_page').show(300);
        $(this).hide();
    });

    if ($('form#supplier_page').length == 1) {
        $('#supplier').change(function () {
            $('#supplier_code').find('option').remove();
            var supplier_code = $(this).find(":selected").val();
            var supplier_name = $(this).find(":selected").text();
            if (supplier_code != 'undefined' && supplier_code != '') {
                $('#supplier_code').append($("<option></option>").attr("value", supplier_code).text(supplier_code));
                $('#supplier_name').val(supplier_name);
            }
        });
    }

    $('.timepicker').datetimepicker({
        format: 'hh:mm:ss',
        pickDate: false
    });

    $('.supplierControl .saveSupplier').click(function (e) {
        e.preventDefault();
        var data = new Object();
        data = {status: $('input[name="status[' + $(this).attr('data-id') + ']"]').val(), bookable_hour_from: $('input[name="bookable_hour_from[' + $(this).attr('data-id') + ']"]').val(), bookable_hour_to: $('input[name="bookable_hour_to[' + $(this).attr('data-id') + ']"]').val()};
        ajaxCall(data, $(this).attr('href'));
    });

    $('.supplierControl .deleteSupplier').click(function (e) {
        e.preventDefault();
        var url = $(this).attr('href');
        BootstrapDialog.show({
            type: BootstrapDialog.TYPE_DANGER,
            title: 'Delete',
            message: 'Are you sure you want to delete this supplier?',
            buttons: [{
                    label: 'Yes',
                    action: function (dialog) {
                        ajaxCall(null, url);
                        dialog.close();
                    }
                }, {
                    label: 'No',
                    action: function (dialog) {
                        dialog.close();
                    }
                }]
        });

    });


    //end supplier page



    $(".defaultChatCategory").on('change', function (event, state) {
        ajaxCall("option=" + $(this).attr('name') + "&value=" + $(this).find(":selected").val());
    });

    $(".globalChatStatus").on('click', function () {
        ajaxCall("option=" + $(this).attr('name') + "&value=" + $(this).attr('value'));
    });

    // Multiselect
    $(".site_id").select2({
        placeholder: "Select a Site"
    });

    $(".select2").select2({
        minimumInputLength: 3
    });

    $(".normalSelect2").select2();

    $('form#page #title').keyup(function () {
        $('form#page #url').val('/' + $(this).val().toUrl());
        editCannonicalUrl($('form#page #url'));
    });
    // wen chenchg page url automatic edit page canonical
    $('form#page #url').on('keyup change', function () {
        $(this).val('/' + $(this).val().toUrl());
        editCannonicalUrl($(this));
    });

    //show the image upload section only when the first tab is clicked
    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        if ($($(this).attr('href')).index() != 0) {
            $('#upload_image, .images-container').hide();
        } else {
            $('#upload_image, .images-container').show();
        }
    })

});

function editCannonicalUrl(url) {
    $('#url_canonical').val('https://' + $('#selectSiteUrl').val() + url.val());

}

init.push(function () {
    $('.bootstrapSwitch').switcher({
        on_state_content: 'Yes',
        off_state_content: 'No'
    });

    $('.bootstrapGlobalChatSwitch').switcher({
        on_state_content: 'On',
        off_state_content: 'Off'
    });

    $('.chatIsDefault').switcher();

    $('.switcher .chatIsDefault').on('click', function () {
        var self = $(this);
        $.ajax({
            url: '/admin/chat/setDefault/' + self.attr('data-id'),
            dataType: 'json',
            type: "get",
            success: function (data) {
                if (!data.isError) {
                    self.parent().closest('div').addClass('checked');
                    $('.chatIsDefault').each(function () {
                        if ($(this).prop('disabled')) {
                            $(this).switcher('enable');
                            $(this).parent().closest('div').removeClass('checked');
                            $("#delete_" + $(this).attr('data-id')).attr('disabled', false);
                        }
                    });
                    self.switcher('disable');
                    $("#delete_" + self.attr('data-id')).attr('disabled', true);
                }
            },
            error: function (data) {

            }
        });
    });

    $('.depositRule').on('click', function (e) {
        e.preventDefault();
        ajaxCall($('.form-horizontal').serialize());
    });

    var depositDatepicker = {
        orientation: $('body').hasClass('right-to-left') ? "auto right" : 'auto auto',
        autoclose: true,
        dateFormat: 'dd/mm/yy',
        format: 'dd/mm/yyyy',
    }
    $('.deposit-datepicker').datepicker(depositDatepicker);

    $('#payment_type').change(function () {
        if ($(this).find(":selected").val() == '3') {
            $('#balance_payment').val(2);
            $('#balance_payment').prop("disabled", true);
        } else {
            $('#balance_payment').prop("disabled", false);
        }
    });

    $('#payment_type, #balance_payment').change(function () {
        $('.tab-criteria > div').each(function () {
            $(this).removeClass('active').removeClass('in');
        });

        var paymenType = $('#payment_type').find(":selected").val();
        var balancePayment = $('#balance_payment').find(":selected").val();

        if (paymenType == 1 && balancePayment == 1) {
            $('#deposit-balance').addClass('active').addClass('in');
            $('#full-balance').addClass('active').addClass('in');
            //Deposit amount tab
            $('#deposit-amount').addClass('active').addClass('in');
            $('#low-deposit-amount').addClass('active').addClass('in');
        } else if (paymenType == 1 && balancePayment == 2) {
            $('#deposit-balance').addClass('active').addClass('in');
            $('#full-balance').addClass('active').addClass('in');
            $('#instalment').addClass('active').addClass('in');
            //Deposit amount tab
            $('#deposit-amount').addClass('active').addClass('in');
            $('#low-deposit-amount').addClass('active').addClass('in');
        } else if (paymenType == 2 && balancePayment == 1) {
            $('#full-balance').addClass('active').addClass('in');
            $('#deposit-amount').addClass('active').addClass('in');
        } else if (paymenType == 2 && balancePayment == 2) {
            $('#full-balance').addClass('active').addClass('in');
            $('#instalment').addClass('active').addClass('in');
            //Deposit amount tab
            $('#deposit-amount').addClass('active').addClass('in');
        } else if (paymenType == 3 && balancePayment == 2) {
            $('#instalment').addClass('active').addClass('in');
        }
    });
    $('#balance_payment').trigger('change');

    $('#collecting_type').change(function () {
        $('.collection-date, .collection-days').hide();
        if ($(this).val() == 1) {
            $('.collection-date').show()
        } else if ($(this).val() == 2 || $(this).val() == 3) {
            $('.collection-days').show();
            if ($(this).val() == 2) {
                $('.departureDate').hide();
                $('.bookingDate').show();
            } else {
                $('.departureDate').show();
                $('.bookingDate').hide();
            }
        }
    });
    $('#collecting_type').trigger('change');

    $('#page-tabs li a').click(function () {
        if ($(this).attr('href') == '#payment-schedule' || $(this).attr('href') == '#deposit-amounts') {
            $('#paymentBalanceDiv').show();
        } else {
            $('#paymentBalanceDiv').hide();
        }
    });

    $('#channel').change(function () {
        $('#supplier').find('option').remove();
        var channel = $(this).find(":selected").val();
        if (channel != 'undefined' && channel != '') {
            $.ajax({
                url: $('#supplierUrl').val() + '/' + channel,
                dataType: 'jsonp',
                type: "get",
                success: function (data) {
                    $('#supplier').append($("<option></option>").attr("value", 'all').text('All - (all)'));
                    $.each(data, function (key, value) {
                        $('#supplier').append($("<option></option>").attr("value", value['code']).text(value['name'] + '('+ value['code'] + ')'));
                    });
                },
                error: function (data) {

                }
            });
        }
    });
});

//$(document).ready(function () {
//    if ($('input.changeSwitchValue[type="checkbox"]').val() == 2) {
//        $('input.changeSwitchValue[type="checkbox"]').prop('checked', false);
//    }
//})

function ajaxCall(data, url)
{
// BlockUI
    var timeout = setTimeout(function () {
        $.blockUI({css: {
                border: 'none',
                padding: '15px',
                backgroundColor: '#000',
                '-webkit-border-radius': '10px',
                '-moz-border-radius': '10px',
                opacity: .5,
                color: '#fff'
            }});
    }, 500);
    url = typeof url !== 'undefined' ? url : '';
    $.ajax({
        url: url,
        dataType: 'json',
        type: "post",
        data: data,
        success: function (data) {
            if (!data.isError && data.action == 'none') {
                return;
            }

            if (!data.isError && data.action == 'redirect') {
                $(location).attr('href', data.url);
                return;
            }
            var title = 'Information';
            if (data.title) {
                title = data.title;
            }

            if (data.alertType == 'growl') {
                var type = 'error';
                if (typeof data.type != 'undefined' && data.type) {
                    if (data.type == 'info') {
                        data.type = 'notice';
                    }                    
                } else if (!data.isError) {
                    if (data.message != 'undefined' && data.message) {
                        data.type = 'notice';
                    }
                }
                $.growl({title: title, message: data.message, style: data.type});
            } else if (data.alertType == 'pageAlert') {
                $('html,body').animate({scrollTop: 0}, 500);
                setTimeout(function () {
                    PixelAdmin.plugins.alerts.clear(true, 'pa_page_alerts_default');
                    var options = {
                        type: data.type,
                        namespace: 'pa_page_alerts_default'
                    };
                    if (!$.isArray(data.message) || !data.message.length) {
                        PixelAdmin.plugins.alerts.add(data.message, options);
                    } else {
                        $.each(data.message, function (k, v) {
                            PixelAdmin.plugins.alerts.add(v, options);
                        });
                    }

                }, 800);
            }
        },
        error: function (data) {
            var message = 'Please contact the support'
            if (data.message) {
                var message = data.message;
            }

            $.growl.error({title: 'Error', message: message});
        },
        complete: function () {
            clearTimeout(timeout);
            $.unblockUI();
        }
    });
}

// call back report date picer 
$('input.datepicker').datepicker({
    format: 'dd/mm/yyyy',
    autoclose: true,
});

var blockUiTimeout = null;

function blockUI() {
    // BlockUI
    blockUiTimeout = setTimeout(function () {
        $.blockUI({css: {
                border: 'none',
                padding: '15px',
                backgroundColor: '#000',
                '-webkit-border-radius': '10px',
                '-moz-border-radius': '10px',
                opacity: .5,
                color: '#fff'
            }});
    }, 500);
}

function unBlockUI() {
    clearTimeout(blockUiTimeout);
    $.unblockUI();
}


$(function () {
    $(document).on('click', '#property button.delete', function (ev) {
        var button = $(this);
        $.ajax({
            type: 'post',
            dataType: 'json',
            url: $(this).attr('href'),
            success: function (data) {
                message(data);
                //remove deleted item from html
                button.parent('label').remove();
            }, error: function () {
                $.growl.error({title: 'Error', message: 'Please contact the support'});
            }
        });
        ev.preventDefault();
    });
// sent ajax request when chenge checkbox
// use $(document).on( becose click event doesn't work in dynamic add html
    $(document).on('change', '#property input[type="checkbox"]', function () {
        var status = $(this).val();
        var href = $(this).next().next().attr('src');
        if (href == undefined) {
            var href = $(this).next().next().next().attr('src');
        }
        if (!$(this).is(':checked')) {
            status = 0;
        }
        $.ajax({
            type: 'post',
            dataType: 'json',
            url: href,
            data: {status: status},
            success: function (data) {
                message(data);
            }, error: function () {
                $.growl.error({title: 'Error', message: 'Please contact the support'});
            }
        });
    });
//submit form with ajax
    $('#property form').submit(function (ev) {
        var actionGroupName = $(this).attr('actionGroupName');
        var input = $(this).find('input[name="title"]')
        $.ajax({
            type: $(this).attr('method'),
            dataType: 'json',
            url: $(this).attr('action'),
            data: $(this).serialize(),
            success: function (data) {
                message(data);
                if (data.isError == false) {
                    $(data.html).appendTo('#' + actionGroupName);
                    input.val('');
                } else {
                    $.growl.error({title: 'Error', message: data.message});
                }
            }, error: function () {
                $.growl.error({title: 'Error', message: 'Please contact the support'});
            }
        });
        ev.preventDefault();
    });
// event a showing modal dialog
// use $(document).on( becose click event doesn't work in dynamic add html
    $(document).on('click', 'a[data-toggle="modal"]', function () {
        // set the date of item
        var modal = $(this).attr('data-target');
        modal = $(modal);

        if ($(this).attr('data-target') == '#offerType') {
            modal.find('input[name="offerTypeTitle"]').val($(this).prev('div').html());
            modal.find('#offer_type_template_id').val($(this).prev().prev().val()).prop('selected', true);
            if ($(this).prev().prev().val() == 0) {
                modal.find('#offer_type_template_id').val($("#offer_type_template_id option:first").val()).prop('selected', true);
            }
            modal.find('input[name="offerTypeLabel"]').val($(this).prev('div').html());
            modal.find('button.edit').attr('src', $(this).attr('src'));
        } else {
            modal.find('input[name="title"]').val($(this).prev('div').html());
            modal.find('button.edit').attr('src', $(this).attr('src'));
        }
    })
//        

// sent request to edit item;
// use $(document).on( becose click event doesn't work in dynamic add html
    $('#myModal button.edit').click(function (ev) {
        // get modal conteiner
        var modal = $('#myModal');
        $.ajax({
            type: 'post',
            dataType: 'json',
            url: modal.find('button.edit').attr('src'),
            data: {
                title: modal.find('input[name="title"]').val(),
            },
            success: function (data) {
                message(data);
                if (data.isError == false) {
                    // set the new name;
                    $('a[src="' + modal.find('button.edit').attr('src') + '"]').prev('div').html(modal.find('input[name="title"]').val());
                    modal.modal('hide')
                } else {
                    $.growl.error({title: 'Error', message: data.message});
                }
            }, error: function () {
                $.growl.error({title: 'Error', message: 'Please contact the support'});
            }
        });
        ev.preventDefault();
    })

    $('#offerType button.edit').click(function (ev) {
        // get modal conteiner
        var modal = $('#offerType');
        $.ajax({
            type: 'post',
            dataType: 'json',
            url: modal.find('button.edit').attr('src'),
            data: {
                title: modal.find('input[name="offerTypeTitle"]').val(),
                template_id: modal.find('#offer_type_template_id').val(),
            },
            success: function (data) {
                message(data);
                if (data.isError == false) {
                    // set the new name;
                    $('a[src="' + modal.find('button.edit').attr('src') + '"]').prev('div').html(modal.find('input[name="offerTypeTitle"]').val());
                    $('a[src="' + modal.find('button.edit').attr('src') + '"]').prev().prev().val(modal.find('#offer_type_template_id').val());
                    modal.modal('hide')
                } else {
                    $.growl.error({title: 'Error', message: data.message});
                }
            }, error: function () {
                $.growl.error({title: 'Error', message: 'Please contact the support'});
            }
        });
        ev.preventDefault();
    })

// show message after evry ajax request
    function message(data) {
        if (!data.isError && data.action == 'none') {
            return;
        }

        var title = 'Information';
        if (data.title) {
            title = data.title;
        }

        if (data.alertType == 'growl') {
            if (!data.isError) {
                if (data.message != 'undefined' && data.message) {
                    type = 'notice';
                } else {
                    type = 'error';
                }
            }
            $.growl({title: title, message: data.message, style: type});
        } else if (data.alertType == 'pageAlert') {
            $('html,body').animate({scrollTop: 0}, 500);
            setTimeout(function () {
                PixelAdmin.plugins.alerts.clear(true, 'pa_page_alerts_default');
                var options = {
                    type: data.type,
                    namespace: 'pa_page_alerts_default'
                };
                if (!$.isArray(data.message) || !data.message.length) {
                    PixelAdmin.plugins.alerts.add(data.message, options);
                } else {
                    $.each(data.message, function (k, v) {
                        PixelAdmin.plugins.alerts.add(v, options);
                    });
                }

            }, 800);
        }
    }


//offers
    if ($('#special_offers').length == 1) {

        function sedDefaultDates() {
            if ($('#live_date').val() == '') {
                var today = new Date();
                $('#live_date').val(moment().format('DD/MM/YYYY'));

                //add 14 dey
                today.setDate(today.getDate() + 14);
                var month = ((today.getMonth() + 1) < 10) ? '0' + (today.getMonth() + 1) : (today.getMonth() + 1);
                var expireDate = today.getDate() + '/' + month + '/' + today.getFullYear();
                $('#expire_date').val(expireDate);
                $('#expire_date').change();
            }
        }


        sedDefaultDates();

        $('#view').click(function () {
            $(this).attr('href', $('#url').val() + '?preview=1');
        });

        $('form#offers').on('submit', function (e) {
            e.preventDefault();
            tinyMCE.triggerSave();
            ajaxCall($(this).serialize(), $(this).attr('action'));
        });

        $("#hotel_id").select2({
            placeholder: "Search for a Offers",
            minimumInputLength: 3,
            ajax: {
                url: "/admin/properties/search",
                dataType: 'json',
                quietMillis: 250,
                data: function (term, page) {
                    return {
                        hotel_name: term,
                        website_id: $('#website_id').val(),
                        page: page
                    };
                },
                results: function (data, page) {
                    var more = (page * 30) < data.total_count;
                    return {results: data.items, more: more};
                }
            },
            dropdownCssClass: "bigdrop"
        }).on("change", function (e) {
            var url = '/offers';
            if ($('#offers_type_id').val() != '') {
                url += '/' + $("#offers_type_id option:selected").text().toUrl();
            }
            url += '/' + $.trim(e.added.text).toUrl();
            $('#url').val(url);
        });

        $("#offers_type_id").change(function () {
            var url = '/offers';
            if ($('#offers_type_id').val() != '') {
                url += '/' + $("#offers_type_id option:selected").text().toUrl();
            }
            if ($('#hotel_id').val() != '') {
                url += '/' + $('span.select2-chosen').html().toUrl();
            }
            $('#url').val(url.replace("'", ''));
        })

        //big search events

        $('button[data-target="#search"]').click(function () {
            $.blockUI({css: {
                    border: 'none',
                    padding: '15px',
                    backgroundColor: '#000',
                    '-webkit-border-radius': '10px',
                    '-moz-border-radius': '10px',
                    opacity: .5,
                    color: '#fff'
                }});
            $.ajax({
                url: '/admin/offers/search',
                type: 'POST',
                dataType: 'JSON',
                data: {
                    hotel_id: $('#hotel_id').val(),
                    offers_type_id: $('#offers_type_id').val(),
                },
                success: function (data) {
                    $('#live_result tbody').html('');
                    $('#expired_result tbody').html('');
                    if (typeof data.live != 'undefined') {
                        $.each(data.live, function (i, item) {
                            offtrs_search(item, 'live_result');
                        });
                    }

                    if (typeof data.expired != 'undefined') {
                        $.each(data.expired, function (i, item) {
                            offtrs_search(item, 'expired_result');
                        });
                    }
                }
                , complete: function () {
                    $.unblockUI();
                }
            });
        });

        $('#copy').click(function () {
            $.blockUI({css: {
                    border: 'none',
                    padding: '15px',
                    backgroundColor: '#000',
                    '-webkit-border-radius': '10px',
                    '-moz-border-radius': '10px',
                    opacity: .5,
                    color: '#fff'
                }});
            $('#id').attr('value', '');
            setTimeout(function () {
                $.unblockUI();
            }, 500);
        });
        // end big search events

        // set default date today and 30 deys in this today
    }

    // end offers

    $('#departure_dates').maxlength({max: 45, showFeedback: 'active'});
    $('#departure_date').maxlength({max: 45, showFeedback: 'active'});

    $('#stropline').maxlength({max: 65, showFeedback: 'active'});
    $('#pod_title').maxlength({max: 25, showFeedback: 'active'});

    $('#pod_text_line1').maxlength({max: 15, showFeedback: 'active'});
    $('#pod_text_line2').maxlength({max: 35, showFeedback: 'active'});
    $('#pod_text_line3').maxlength({max: 35, showFeedback: 'active'});
    $('#pod_text_line4').maxlength({max: 35, showFeedback: 'active'});

    // view option
    if ($('#view_options').length == 1) {
        $('button[action="delete all"]').click(function (e) {
            e.preventDefault();
            var button = $(this);
            BootstrapDialog.show({
                type: BootstrapDialog.TYPE_DANGER,
                title: 'Delete',
                message: 'Are you sure you want to delete this offers',
                buttons: [{
                        label: 'Yes',
                        action: function (dialog) {
                            $.blockUI({css: {
                                    border: 'none',
                                    padding: '15px',
                                    backgroundColor: '#000',
                                    '-webkit-border-radius': '10px',
                                    '-moz-border-radius': '10px',
                                    opacity: .5,
                                    color: '#fff'
                                }});
                            $.ajax({
                                url: button.attr('href'),
                                type: 'GET',
                                dataType: 'JSON',
                                success: function (data) {
                                    if (data.isError == false) {
                                        button.parent().parent().parent().next().find('tr').each(function () {
                                            $('tr[data-id="' + $(this).attr('data-id') + '"]').each(function () {
                                                $(this).remove();
                                            });
                                        });
                                        button.parent().parent().parent().parent().parent().parent().parent().remove();
                                    }
                                    dialog.close();
                                }, complete: function () {
                                    $.unblockUI();
                                    dialog.close();
                                }
                            });
                        }
                    }, {
                        label: 'No',
                        action: function (dialog) {
                            dialog.close();
                        }
                    }]
            });
        });

        $('button[action="delete"]').click(function (e) {
            e.preventDefault();
            var button = $(this);
            BootstrapDialog.show({
                type: BootstrapDialog.TYPE_DANGER,
                title: 'Delete',
                message: 'Are you sure you want to delete this offers',
                buttons: [{
                        label: 'Yes',
                        action: function (dialog) {
                            $.blockUI({css: {
                                    border: 'none',
                                    padding: '15px',
                                    backgroundColor: '#000',
                                    '-webkit-border-radius': '10px',
                                    '-moz-border-radius': '10px',
                                    opacity: .5,
                                    color: '#fff'
                                }});
                            $.ajax({
                                url: button.attr('href'),
                                type: 'GET',
                                dataType: 'JSON',
                                success: function (data) {
                                    if (data.isError == false) {
                                        $('tr[data-id="' + button.parent().parent().attr('data-id') + '"]').each(function () {
                                            $(this).remove();
                                        });
                                    }
                                    dialog.close();
                                }, complete: function () {
                                    $.unblockUI();
                                }
                            });
                        }
                    }, {
                        label: 'No',
                        action: function (dialog) {
                            dialog.close();
                        }
                    }]
            });
        });
    }

    // end view option
});
function offtrs_search(item, selector) {

    if (item.hotel.length == 0) {
        return;
    }

    var result = item;
    var offersItem = result.item;
    var hotel = result.hotel[0];
    var additional_content = result.additional_content;
    var additional_content_rows = result.additional_content_rows;
    var airports = result.airports;
    var offers_type = result.offers_type;

    var row = $("<tr/>");
    $("<th/>", {html: hotel.hotel_name}).appendTo(row);
    $("<th/>", {html: hotel.resort}).appendTo(row);
    $("<th/>", {html: hotel.country}).appendTo(row);
    $("<th/>", {html: offers_type ? offers_type.label : ''}).appendTo(row);
    $("<th/>", {html: offersItem.live_date ? moment(offersItem.live_date, "YYYY-MM-DD").format('DD/MM/YYYY') : ''}).appendTo(row);
    $("<th/>", {html: offersItem.expire_date ? moment(offersItem.expire_date, "YYYY-MM-DD").format('DD/MM/YYYY') : ''}).appendTo(row);
    $("<th/>").append($("<a/>", {
        class: "col-md-1",
        href: "#",
        html: 'View/Edit',
    }).on('click', function (e) {
        e.preventDefault();
        var offtrs = item.item;
        var hotel = item.hotel[0];

        var pods = item.pods;

        $('#id').val(offtrs.id);

        $("#hotel_id").select2("data", {id: hotel.id, text: $.trim(hotel.hotel_name)});
        tinyMCE.get('description').setContent(offtrs.description);
        $('#url').val($.trim(offtrs.url));
        $('#price').val(offtrs.price);
        $('#nights').val(offtrs.nights);
        $('#departure_date').val(offtrs.departure_date);
        $('#abults').val(offtrs.abults);
        $('#children').val(offtrs.children);
        $('#pod_title').val(offtrs.pod_title);
        $('#pod_text_line1').val(offtrs.pod_text_line1);
        $('#pod_text_line2').val(offtrs.pod_text_line2);
        $('#pod_text_line3').val(offtrs.pod_text_line3);
        $('#pod_text_line4').val(offtrs.pod_text_line4);
        $('#stropline').val(offtrs.stropline);
        $('#description').val(offtrs.description);
        $('#live_date').val(moment(offtrs.live_date, "YYYY-MM-DD").format('DD/MM/YYYY'));
        $('#live_date').change();
        $('#expire_date').val(moment(offtrs.expire_date, "YYYY-MM-DD").format('DD/MM/YYYY'));
        $('#expire_date').change();
        $("#offers_type_id").val(offtrs.offers_type_id).prop('selected', true);
        $("#departure_airport_id").val(offtrs.departure_airport_id).prop('selected', true);
        $("#departure_date").val(offtrs.departure_date);
        $("#price_type_id").val(offtrs.price_type_id).prop('selected', true);
        $("#board_type_id").val(offtrs.board_type_id).prop('selected', true);
        $("#gate").val(offtrs).prop('selected', true);

        $("#additional_content_sortable").html('');

        $('#meta_title').val(offtrs.meta_title);
        $('#meta_keywords').val(offtrs.meta_keywords);
        $('#meta_description').val(offtrs.meta_description);

        $('#additional_content_id').val(offtrs.additional_content_id);
        if (additional_content != undefined) {
            $('#additional_content_name').val(additional_content.title);
            $("#additional_content_type").val(additional_content.content_type).prop('selected', true);
            if (additional_content_rows != undefined) {
                loadAdditionalContentRows(additional_content_rows);
            }
        }

        $("#destination_id").val(offtrs.destination_id).prop('selected', true);
        $("#departure_id").val(offtrs.departure_id).prop('selected', true);
        $("#board_basis_id").val(offtrs.board_basis_id).prop('selected', true);
        $("#star_rating_id").val(offtrs.star_rating_id).prop('selected', true);

        if (offtrs.destination_only == 1)
            $('#destination_only').prop('checked', offtrs.destination_only);
        if (offtrs.departure_only == 1)
            $('#departure_only').prop('checked', offtrs.departure_only);
        if (offtrs.board_basis_only == 1)
            $('#board_basis_only').prop('checked', offtrs.board_basis_only);
        if (offtrs.star_rating_only == 1)
            $('#star_rating_only').prop('checked', offtrs.star_rating_only);

        $("#status").val(offtrs.status).prop('selected', true);
        $("#chat_id").val(offtrs.chat_id).prop('selected', true);

        $.each(item.inclides, function (i, item) {
            $('input[name="offerInclude[' + item.id + ']"]').prop('checked', true);
        })
        $.each(item.charges, function (i, item) {
            $('input[name="additionalCharge[' + item.id + ']"]').prop('checked', true);
        });

        if (pods) {
            $.each(pods, function (i, item) {
                setPod(item.id, item.hotel_name + ', ' + item.country + ', ' + item.label, item.page_type);
            });
        }

        $('#search button.btn-primary').click();
        $("#destination_id").change();
        $("#departure_id").change();
        $("#board_basis_id").change();
        $("#star_rating_id").change();

    })).appendTo(row);
    row.appendTo($('#' + selector + ' tbody'));
}


function loadAdditionalContentRows(additional_content_rows) {
    $.each(additional_content_rows, function (i, item) {
        var number = 0;
        if ($('#additional_content_sortable').children('tr') != undefined)
            number = $('#additional_content_sortable').children('tr').length;

        var holder = $("<tr/>", {id: 'row_' + number});
        var content = $("<td/>", {class: "text-left"})
        $('<p/>').html(item.title).appendTo(content);
        $("<input/>", {type: "hidden", name: 'row_id[]', class: 'row_id', value: item.id}).appendTo(content);
        $("<input/>", {type: "hidden", name: 'row_title[]', class: 'row_title', value: item.title}).appendTo(content);
        $("<input/>", {type: "hidden", name: 'row_body[]', class: 'row_body', value: item.body}).appendTo(content);
        var editButton = $("<td/>", {class: "text-center"});
        $("<a/>", {onclick: "edit('row_" + number + "')", class: 'btn btn-sm btn-success'}).html('<span class="fa fa-pencil"></span> Edit').appendTo(editButton);
        var deleteButton = $("<td/>", {class: "text-center"});
        $("<a/>", {onclick: "deleteF('row_" + number + "')", class: 'btn btn-sm btn-danger'}).html('<span class="fa fa-trash-o"></span> Delete').appendTo(deleteButton);
        content.appendTo(holder);
        editButton.appendTo(holder);
        deleteButton.appendTo(holder);
        holder.appendTo($('#additional_content_sortable'));
    })

    $('.additional_content_container').removeClass('hidden');
}
