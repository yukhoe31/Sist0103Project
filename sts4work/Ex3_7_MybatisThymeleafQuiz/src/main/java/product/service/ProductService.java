package product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import product.dto.ProductDto;
import product.mapper.ProductMapper;

@Service
@AllArgsConstructor
public class ProductService {

	private final ProductMapper proMapper;
	
	public int getTotalCount()
	{
		return proMapper.getTotalCount();
	}
	public void insertProduct(ProductDto dto) 
	{
		proMapper.insertProduct(dto);
	}
	public List<ProductDto> getAllProducts()
	{
		return proMapper.getAllProducts();
	}
	
	public ProductDto getData(int pro_num)
	{
		return proMapper.getData(pro_num);
	}
	
	public void deleteProduct(int pro_num)
	{
		proMapper.deleteProduct(pro_num);
	}
}
