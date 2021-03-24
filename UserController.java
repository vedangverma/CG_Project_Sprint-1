/**
	 * @author Vedang
	 * @param ownerId - id of owner
	 * @return owner
	 */
	@ApiOperation(value = "Get owner by Id",
			response = Owner.class,
			tags = "get-owner",
			consumes = "ownerId",
			httpMethod = "GET")
	@GetMapping("/owner/{ownerId}")
	public ResponseEntity<Owner> getOwnerById(@PathVariable Integer ownerId){
		try {
			Owner owner = ownerService.findByPk(ownerId);
			return new ResponseEntity<>(owner,HttpStatus.OK);
		}catch(RecordNotFoundException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Vedang
	 * @return all owners
	 */
	@ApiOperation(value = "Get all owners",
			response = Owner.class,
			tags = "get-all-owners",
			httpMethod = "GET")
	@GetMapping("/owner")
	public ResponseEntity<List<Owner>> getAllOwners(){
		try {
			List<Owner> ownerList = ownerService.search();
			return new ResponseEntity<>(ownerList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}
	
	/**
	 * @author Vedang
	 * @param pageNo - page number
	 * @param pageSize - page size
	 * @return owner of the pageNo with pageSize
	 */
	@ApiOperation(value = "Get owner by page no and page size",
			response = Owner.class,
			tags = "get-owner",
			consumes = "pageNo and PageSize",
			httpMethod = "GET")
	@GetMapping("/owner/{pageNo}/{pageSize}")
	public ResponseEntity<List<Owner>> getOwner(@PathVariable Integer pageNo,@PathVariable Integer pageSize){
		try {
			List<Owner> ownerList = ownerService.search(pageNo, pageSize);
			return new ResponseEntity<>(ownerList,HttpStatus.OK);
		}catch(DatabaseException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
	}