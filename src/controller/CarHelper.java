package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Car;

public class CarHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CarCatalog");
	
	public void InsertItem(Car own) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(own);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Car> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		// was getting "Type safety: The expression of type List needs unchecked conversion to conform to List<ListItem>" so I added "@SuppressWarnings("unchecked")"
		@SuppressWarnings("unchecked")
		List<Car> allItems = em.createQuery("SELECT i FROM ListItem i").getResultList();
		return allItems;
		}
	
	public void deleteItem(Car toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select li from ListItem li where li.store = :selectedStore and li.item = :selectedItem", Car.class);
		
		//Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		typedQuery.setParameter("selectedColor", toDelete.getColor());
		typedQuery.setParameter("selectedMileage", toDelete.getMileage());
		typedQuery.setParameter("selectedPrice", toDelete.getPrice());
		typedQuery.setParameter("selectedOwners", toDelete.getOwners());
		
		//we only want one result
		typedQuery.setMaxResults(1);
		
		//get the result and save it into a new list item
		Car result = typedQuery.getSingleResult();
		
		//remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Car searchForItemById(int idToEdit) {
	EntityManager em = emfactory.createEntityManager();
	em.getTransaction().begin();
	Car found = em.find(Car.class, idToEdit);
	em.close();
	return found;
	}

	public void updateItem(Car toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		}

	public List<Car> searchForItemByStore(String CarName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select li from ListItem li where li.store = :selectedStore", Car.class);
		typedQuery.setParameter("selectedStore", CarName);
		List<Car> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Car> searchForItemByItem(String contactNumber) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Car> typedQuery = em.createQuery("select li from ListItem li where li.item = :selectedItem", Car.class);
		typedQuery.setParameter("selectedItem", contactNumber);
		List<Car> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
		}
	
	public void cleanUp() {
		emfactory.close();
	}
}