package Equipment.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EquipmentRegistController {

	@RequestMapping(value="EquipmentRegist.eq")
	public String goEquipmentRegistForm() {
		return "EquipmentRegistForm";
	}
}
