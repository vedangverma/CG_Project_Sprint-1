	/**
	 * @author Vedang
	 * @param flatDetailsId - id of flatdetails
	 * @return flatDetails
	 */
	@ApiOperation(value = "get flat details by id",
			response = FlatDetails.class,
			tags = "get-flatdetails",
			consumes = "flatDetailsId",
			httpMethod = "GET")
	@GetMapping("/flatDetails/{flatDetailsId}")
	public ResponseEntity<FlatDetails> getFlatDetailsById(@PathVariable Integer flatDetailsId){
		try {
			FlatDetails flatDetails = flatDetailsService.findByPk(flatDetailsId);
			return new ResponseEntity<>(flatDetails,HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Vedang
	 * @return all flatDetails
	 */
	@ApiOperation(value = "get all flat details",
			response = FlatDetails.class,
			tags = "get-all-flatdetails",
			httpMethod = "GET")
	@GetMapping("/flatDetails")
	public ResponseEntity<List<FlatDetails>> getAllFlatDetails(){
		try {
			List<FlatDetails> flatDetailsList = flatDetailsService.search();
			return new ResponseEntity<>(flatDetailsList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Vedang
	 * @param pageNo - page number
	 * @param pageSize - page size
	 * @return flatDetails of the pageNo with pageSize
	 */
	@ApiOperation(value = "get flat details by page no and page size",
			response = FlatDetails.class,
			tags = "get-flatdetails",
			consumes = "page no and page size",
			httpMethod = "GET")
	@GetMapping("/flatDetails/{pageNo}/{pageSize}")
	public ResponseEntity<List<FlatDetails>> getflatDetails(@PathVariable Integer pageNo,@PathVariable Integer pageSize){
		try {
			List<FlatDetails> flatDetailsList = flatDetailsService.search(pageNo, pageSize);
			return new ResponseEntity<>(flatDetailsList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Vedang
	 * @param flatDetails - flat object
	 * @return adds flatDetails
	 */
	@ApiOperation(value = "add flat details",
			response = Integer.class,
			tags = "add-flatdetails",
			consumes = "flatDetails object",
			httpMethod = "POST")
	@PostMapping("/flatDetails")
	public ResponseEntity<Integer> addFlatDetails(@RequestBody FlatDetails flatDetails) {
		try {
			Integer flatDetailsId = flatDetailsService.addFlatDetails(flatDetails);
			return new ResponseEntity<>(flatDetailsId,HttpStatus.OK);
		}catch(DuplicateRecordException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Vedang
	 * @param flatDetails - flat object
	 * @return updating flatDetails
	 */
	@ApiOperation(value = "update flat details",
			response = String.class,
			tags = "update-flatdetails",
			consumes = "flatDetails object",
			httpMethod = "PUT")
	@PutMapping("/flatDetails")
	public ResponseEntity<String> updateFlatDetails(@RequestBody FlatDetails flatDetails) {
		try {
			flatDetailsService.updateFlatDetails(flatDetails);
			return new ResponseEntity<>("updated successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Vedang
	 * @param flatDetails - flat object
	 * @return deleting flatDetails
	 */
	@ApiOperation(value = "delete flat details",
			response = String.class,
			tags = "delete-flatdetails",
			consumes = "flatDetails object",
			httpMethod = "DELETE")
	@DeleteMapping("/flatDetails")
	public ResponseEntity<String> deleteflatDetails(@RequestBody FlatDetails flatDetails) {
		try {
			flatDetailsService.deleteFlatDetails(flatDetails);
			return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}

}
