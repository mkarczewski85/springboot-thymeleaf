var app = angular.module("appManager", []);

//materialController
app.controller("materialManagerController", function ($scope, $http) {

    //load the data from server
    _refreshMaterialData();

    //HTTP POST method for add material
    $scope.submitMaterial = function () {

        $http({
            method: "POST",
            url: "http://localhost:8080/material",
            data: angular.toJson($scope.formData),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    //HTTP DELETE- delete material by Id
    $scope.removeMaterial = function (material) {
        $http({
            method: 'DELETE',
            url: 'http://localhost:8080/material/' + material.ID
        }).then(_success, _error);
    };

    //In case of edit material, populate form with material data
    $scope.editMaterial = function (material) {
        $scope.formData.ID = material.ID;
        $scope.formData.name = material.name;
        $scope.formData.companyID = material.companyID;
    };

    //HTTP PUT- update material by Id
    $scope.updateMaterial = function () {
        $http({
            method: "PUT",
            url: "http://localhost:8080/material/" + $scope.formData.ID,
            data: angular.toJson($scope.formData),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    //reset list of materials to starting point
    $scope.resetMaterials = function () {
        $http({
            method: "PATCH",
            url: "http://localhost:8080/material",
        }).then(_success, _error);
    };

    /* Private Methods */

    //HTTP GET- get all material collection
    function _refreshMaterialData() {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/material'
        }).then(function successCallback(response) {
            $scope.materials = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }

    //refresh page after HTTP response succes
    function _success(response) {
        _refreshMaterialData();
        _clearMaterialForm()
    }

    function _error(response) {
        console.log(response.statusText);
        alert("Error occured!");
    }

    //clear the form
    function _clearMaterialForm() {
        $scope.formData.ID = "";
        $scope.formData.name = "";
        $scope.formData.companyID = "";
    };

});
//companyController
app.controller("companyManagerController", function ($scope, $http) {

    //load the data from server
    _refreshCompanyData();

    //HTTP POST method for add new company
    $scope.submitCompany = function () {

        $http({
            method: "POST",
            url: "http://localhost:8080/company",
            data: angular.toJson($scope.formData),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    //HTTP DELETE- delete company by Id
    $scope.removeCompany = function (company) {
        $http({
            method: 'DELETE',
            url: 'http://localhost:8080/company/' + company.companyID
        }).then(_success, _error);
    };

    //In case of edit company, populate form with company data
    $scope.editCompany = function (company) {
        $scope.formData.companyID = company.companyID;
        $scope.formData.companyName = company.companyName;
    };

    //HTTP PUT- update company by Id
    $scope.updateCompany = function () {
        $http({
            method: "PUT",
            url: "http://localhost:8080/company/" + $scope.formData.companyID,
            data: angular.toJson($scope.formData),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    //reset list of company to starting point
    $scope.resetCompanies = function () {
        $http({
            method: "PATCH",
            url: "http://localhost:8080/company",
        }).then(_success, _error);
    };

    /* Private methods */

    //HTTP GET- get all company collection
    function _refreshCompanyData() {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/company'
        }).then(function successCallback(response) {
            $scope.companies = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }

    //refresh page after HTTP response succes
    function _success(response) {
        _refreshCompanyData();
        _clearCompanyForm()
    }

    function _error(response) {
        console.log(response.statusText);
        alert("Error occured!");
    }

    //Clear the form
    function _clearCompanyForm() {
        $scope.formData.companyID = "";
        $scope.formData.companyName = "";
    };
});

app.directive('ngConfirmClick', [
    function(){
        return {
            link: function (scope, element, attr) {
                var msg = attr.ngConfirmClick || "Are you sure?";
                var clickAction = attr.confirmedClick;
                element.bind('click',function (event) {
                    if (window.confirm(msg) ) {
                        scope.$eval(clickAction)
                    }
                });
            }
        };
    }]);