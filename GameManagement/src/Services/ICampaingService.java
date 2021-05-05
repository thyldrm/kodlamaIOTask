package Services;

import Entities.Campaign;

public interface ICampaingService {
	void save(Campaign campaign);
	void update(Campaign campaign);
	void delete(Campaign campaign);
}