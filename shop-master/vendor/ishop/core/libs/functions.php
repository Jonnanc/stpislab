<?php

function debug($arr, $die = false){
    echo '<pre>' . print_r($arr, true) . '</pre>';
    if($die) die;
}

function redirect($http = false, $api = false, $data = null){
    if($http) {
        $redirect = $http;
    }
    if($http){
        $redirect = $http;
    }else{
        $redirect = isset($_SERVER['HTTP_REFERER']) ? $_SERVER['HTTP_REFERER'] : PATH;
    }
    header("Location: $redirect");
    exit;
}

function h($str){
    return htmlspecialchars($str, ENT_QUOTES);
}