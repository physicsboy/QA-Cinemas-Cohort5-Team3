"use strict";

(function () {

    angular.module("movieApp").service("blockDal", ["dal", BlockDal]);

    function BlockDal (dal) {

        this.getBlock = function () {
            return dal.http.GET("rest/block/json"  + blockId);
        };
        
        this.getBlocksForScreen = function () {
            return dal.http.GET("rest/block/json/screen" + screenId);
        };
        
        this.addBlock = function () {
            return dal.http.POST("rest/block/json" + block);
        };
        
        
        
        this.increaseStartingCol = function () {
            return dal.http.PUT("rest/block/json/increase/startColumn" + id  + newMax);
        };
        this.decreaseStartingCol = function () {
            return dal.http.PUT("rest/block/json/decrease/startColumn" + id  + newMin);
        };
        this.increaseStartingRow = function () {
            return dal.http.PUT("rest/block/json/increase/startRow" + id  + newMax);
        };
        this.decreaseStartingCol = function () {
            return dal.http.PUT("rest/block/json/decrease/startRow" + id  + newMin);
        };

        
        
        this.updateBlock = function () {
            return dal.http.PUT("rest/block/json/update" + id + xPosition + yPosition + angle);
        };
        
        
        
        this.deleteBlock = function () {
            return dal.http.Delete("rest/block/json" + id);
        };
        
        
        
        
        
    }
}());