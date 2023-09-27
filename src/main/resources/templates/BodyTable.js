var url = "/selectMany"
var data = [];
        $.ajax({
            type : 'GET',
            url : url,
            dataType : 'json'
        }).then(
                function(json) {
                    for (var i = 0; i < json.length; i++) {
                        data.push({
// エスケープ回避のためのコメントなので無視してください<code>[i]</code>
                            'name' : json[i].name,
                            'weight' : json [i].weight,
                            'fat_per' : json [i].fat_per
                        });
                    };
                    
                    console.log(data);
                    var j = '<tr><th>名前</th><th>体重</th><th>体脂肪率</th></tr>';
                    $("table#wrap").append(j);
                    for (var i = 0; i < data.length; i++) {
                        var h = '<tr><td>' + data[i].name + '</td>'
                                + '<td>' + data[i].weight + '</td>' + '<td>'
                                + data[i].fat_per + '</td></tr>';
                        $("table#wrap").append(h);
                    }
                });