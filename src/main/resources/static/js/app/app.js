var demo = angular.module("demo", []);
demo.controller("demoCtr", function($scope, $http) {
	$scope.rows = 0;
	$scope.columns = 0;
	$scope.matVal = [];
	$scope.responseDisabled = true;

	$scope.getRows = function() {
		return new Array($scope.rows);
	}

	$scope.getColumns = function() {
		return new Array($scope.columns);
	}

	$scope.getSpiralPath = function() {
		var stringValues = "";
		angular.forEach($scope.matVal, function(value) {
			angular.forEach(value, function(val) {
				stringValues += val+" ";	
			})
		})
		$http({
			url : "/getMatrix",
			method : "GET",
			params : {
				rows : $scope.rows,
				columns : $scope.columns,
				matrixValues : stringValues.trim()
			}
		}).then(function mySuccess(response) {
			$scope.responseDisabled = false;
			var resp = response.data
			$scope.response = resp.join(" ");
		}, function myError(response) {
			console.log(response);
		});
	}

});